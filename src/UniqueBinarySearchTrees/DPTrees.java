package UniqueBinarySearchTrees;

import java.util.LinkedList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class DPTrees {
    public static void main(String[] args) {
        System.out.println(generate(2));
    }

    /**
     * DP算法，简单高效，但是思考较困难
     * 将1放入1号位置
     * 将2插入1之前或者1之后两种操作
     * 将添加的节点作为原来节点的头结点
     * 或者遍历节点右节点，将可以增加的节点添加到每个遍历的右节点的最右边
     * @param n
     * @return
     */
    private static List<TreeNode> generate(int n){
        LinkedList<TreeNode> list=new LinkedList<>();
        if(n==0) return list;
        Trees(n,list);
        return list;
    }
    private static void Trees(int n,LinkedList<TreeNode> list){
        if(n==1){
            list.add(new TreeNode(n));
            return;
        }
        //分成两种情况是：一种是插入头部，一种是插到右边
        //节点插向头部以及插向右边两种情况分类讨论
        //遍历所有右子树的所有右节点，插到右节点的右边就可以。如果右节点不为空，插入的新节点的左指向原右节点的右
        Trees(n-1,list);
        int size=list.size();
        for(int i=0;i<size;i++){
            TreeNode treeNode=list.removeFirst();
            TreeNode newNode=new TreeNode(n);
            newNode.left=treeNode;
            list.add(newNode);
            TreeNode root=treeNode;
            //找到所有右节点对应的val,重新构建树
            while(treeNode!=null){
                TreeNode node=new TreeNode(n);
                list.add(copyAndCreate(root,treeNode.val,node));
                treeNode=treeNode.right;
            }
        }
    }
    //重新构建树，不能影响之前树的排列，需要重新构建BST
    private static TreeNode copyAndCreate(TreeNode root,int val,TreeNode node){
        if(root==null){
            return null;
        }
        TreeNode newRoot=new TreeNode(root.val);
        if(val!=root.val){
            newRoot.left=copyAndCreate(root.left,val,node);
            newRoot.right=copyAndCreate(root.right,val,node);
        }else{
            newRoot.right=node;
            newRoot.left=copyAndCreate(root.left,val,node);
            node.left=copyAndCreate(root.right,val,node);
        }
        return newRoot;
    }
}

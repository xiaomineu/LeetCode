package ConstructBinaryTreeFromInorderandPostorderTraversal;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class buildTree {
    public static void main(String[] args) {

    }

    /**
     * 根据中序遍历及后序遍历序列构建二叉树
     * 与前序遍历及中序遍历构建二叉树类似
     * 后序遍历中根节点在最后访问
     * 依照后序遍历构建树
     * 根据后序遍历中的根节点，从中序遍历中确定左右孩子个数
     * @param inorder 中序遍历序列
     * @param postorder 后序遍历序列
     * @return
     */
    private static TreeNode build(int[] inorder,int[] postorder){
        return BinaryTree(postorder,inorder,postorder.length-1,0,0);
    }
    private static TreeNode BinaryTree(int[] posrorder,int[] inorder,int start,int end,int offset){
        if(posrorder==null||start<end){
            return null;
        }
        int index=findIndex(posrorder[start-offset],inorder);
        TreeNode root=new TreeNode(posrorder[start-offset]);
        root.right=BinaryTree(posrorder,inorder,start,index+1,offset+1);
        root.left=BinaryTree(posrorder,inorder,index-1,end,offset);
        return root;
    }
    private static int findIndex(int value,int[] inorder){
        if(inorder==null){
            return -1;
        }
        for(int i=0;i<inorder.length;i++){
            if(value==inorder[i]){
                return i;
            }
        }
        return -1;
    }
}

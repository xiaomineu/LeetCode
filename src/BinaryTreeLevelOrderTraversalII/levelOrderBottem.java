package BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class levelOrderBottem {
    public static void main(String[] args) {

    }

    /**
     * 层序遍历中从底层依次向上输出
     * 将每层中的数值采用头插法，即完成倒序
     * @param root
     * @return
     */
    private static List<List<Integer>> levelFromBottem(TreeNode root){
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            List<Integer> template=new ArrayList<>();
            for(int i=0;i<len;i++){
                root=queue.poll();
                template.add(root.val);
                if(root.left!=null){
                    queue.add(root.left);
                }
                if(root.right!=null){
                    queue.add(root.right);
                }
            }
            list.add(0,template);
        }
        return list;
    }
}

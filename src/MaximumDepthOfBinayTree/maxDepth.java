package MaximumDepthOfBinayTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class maxDepth {
    public static void main(String[] args) {

    }
    private static int Depth(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();

        int depth=0;
        if(root==null){
            return depth;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int length=queue.size();
            for(int i=0;i<length;i++){
                root=queue.poll();
                if(root.left!=null){
                    queue.offer(root.left);
                }
                if(root.right!=null){
                    queue.offer(root.right);
                }
            }
            depth++;
        }
        return depth;
    }
}

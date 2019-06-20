package BinaryTreeMaximumPathSum;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class maxPathsum {
    public static void main(String[] args) {
    }
    int max=Integer.MIN_VALUE;
    private int maxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        //找到左右节点中最大值;
        int left=Math.max(0,maxPath(root.left));
        int right=Math.max(0,maxPath(root.right));
        max=Math.max(max,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}

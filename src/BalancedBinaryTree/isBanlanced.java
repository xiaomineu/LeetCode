package BalancedBinaryTree;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class isBanlanced {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(2);
//        root.left.left=new TreeNode(3);
//        root.left.left.left=new TreeNode(4);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(3);
        System.out.println(isBalancedTree(root));
    }
    //runtime beats 84.67% Memory:beats 100%
    private static boolean isBalancedTree(TreeNode root){
        return depth(root)==-1?false:true;
    }
    private static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftdepth=depth(root.left);
        int rightdepth=depth(root.right);
        if(leftdepth==-1||rightdepth==-1){
            return -1;
        }
        if(Math.abs(leftdepth-rightdepth)<=1){
            return Math.max(leftdepth,rightdepth)+1;
        }else{
            return -1;
        }
    }
}

package MinimumDepthOfBinaryTree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class minDepth {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
//        root.right.right=new TreeNode(7);
        System.out.println(min(root));
    }
    private static int min(TreeNode root){
        return findMinDepth(root);
    }
    //最小树深度

    /**
     *
     * @param root
     * @return
     */
    private static int findMinDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        //左右孩子都为空时，该树深为1;
        if(root.left==null&&root.right==null){
            return 1;
        }
        //左右孩子有一个为null时，树深为不为null的孩子+1;
        if(root.left==null) return 1+findMinDepth(root.right);
        if(root.right==null) return 1+findMinDepth(root.left);
        return Math.min(findMinDepth(root.left),findMinDepth(root.right))+1;
    }
}

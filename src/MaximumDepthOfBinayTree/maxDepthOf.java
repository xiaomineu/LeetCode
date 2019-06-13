package MaximumDepthOfBinayTree;

public class maxDepthOf {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        depthMax(root);
    }

    /**
     * 递归判断左子树以及右子树
     * @param root
     * @return
     */
    private static int depthMax(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(depthMax(root.left),depthMax(root.right))+1;
    }
}

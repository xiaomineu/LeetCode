package PathSum;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class hasPathSum {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(-2);
        root.right=new TreeNode(-3);
//        root.left=new TreeNode(4);
//        root.right=new TreeNode(8);
//        root.left.left=new TreeNode(11);
//        root.left.left.left=new TreeNode(7);
//        root.left.left.right=new TreeNode(3);
//        root.right.left=new TreeNode(13);
//        root.right.right=new TreeNode(4);
//        root.right.right.right=new TreeNode(1);
        hasPathSum hasPathSum=new hasPathSum();
        System.out.println(hasPathSum.hasPath(root,-5));
    }
    private boolean hasPath(TreeNode root,int sum){
        return sumPath(root,sum);
    }
    //二叉树中路径问题需要考虑节点中为负数的情况
    //将目标值与节点数值相减，判断路径末端目标值是否仍为0;
    private boolean sumPath(TreeNode root,int sum){
        if(root==null){
            if(sum==0){
                return false;
            }
        }else{
            boolean result=false;
            int subSum=sum-root.val;
            sumPath(root.left,sum);
            if(subSum==0&&root.left==null&&root.right==null){
                return true;
            }
            if(root.left!=null){
                result=result||sumPath(root.left,subSum);
            }
            if(root.right!=null){
                result=result||sumPath(root.right,subSum);
            }
            return result;
        }
        return false;
    }
}

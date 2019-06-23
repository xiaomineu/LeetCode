package SumRootLeafNumbers;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class sumNumbers {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        System.out.println(sum(root));
    }
    //深搜遍历所有路径节点数字
    private static int sum(TreeNode root){
        int tem=0;
        sumOfNode(tem,root);
        return result;
    }
    private static int result=0;
    private static void sumOfNode(int tem,TreeNode root){
        int s=tem*10+root.val;
        if(root.left==null&&root.right==null){
            result+=s;
            return;
        }

        if(root.left!=null)sumOfNode(tem,root.left);

        if(root.right!=null)sumOfNode(tem,root.right);
    }
}

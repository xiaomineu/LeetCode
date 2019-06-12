package sameTree;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class isSame {
    public static void main(String[] args) {
        TreeNode p=new TreeNode(1);
        p.left=new TreeNode(2);
//        p.right=new TreeNode(3);
        TreeNode q=new TreeNode(1);
//        q.left=new TreeNode(3);
        q.right=new TreeNode(2);
        System.out.println(isSameTree(p,q));
    }
    public static boolean isSameTree(TreeNode p,TreeNode q){
        return judge(p,q);
    }
    private static boolean judge(TreeNode p,TreeNode q){
        if(p==null||q==null){
            if(p==null&&q==null){
                return true;
            }else
                return false;
        }
        if(judge(p.left,q.left)){
            if(p.val==q.val){
                return judge(p.right,q.right);
            }else
                return false;
        }
        return false;
    }
}

package SymmertricTree;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class isSymmetric {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(4);
        System.out.println(isSymmetricTree(root));
    }
    private static boolean isSymmetricTree(TreeNode root){
        if(root==null){
            return true;
        }
        TreeNode leftChild=root.left;
        TreeNode rightChild=root.right;
        return judge(leftChild,rightChild);
    }
    private static boolean judge(TreeNode leftChild,TreeNode rightChild){
        if(leftChild==null||rightChild==null){
            if(leftChild==null&&rightChild==null){
                return true;
            }else
                return false;
        }
        if(leftChild.val==rightChild.val){
            if(judge(leftChild.left,rightChild.right)&&judge(leftChild.right,rightChild.left)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}

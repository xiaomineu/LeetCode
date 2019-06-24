package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class preOrderTravelsal {
    public static void main(String[] args) {

    }
    private static List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        preOrder(result,root);
        return result;
    }
    private static void preOrder(List<Integer> result,TreeNode root){
        if(root==null){
            return;
        }
        result.add(root.val);
        preOrder(result,root.left);
        preOrder(result,root.right);
    }
}

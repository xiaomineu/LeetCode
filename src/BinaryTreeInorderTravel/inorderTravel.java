package BinaryTreeInorderTravel;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x){
        val=x;
    }
}
public class inorderTravel {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        System.out.println(inorder(root));
    }
    //二叉树中序遍历
    private static List<Integer> inorder(TreeNode root){
        List<Integer> list=new ArrayList<>();
        BinaryTravel(list,root);
        return list;
    }
    private static void BinaryTravel(List<Integer> list,TreeNode root){
        if(root!=null){
            BinaryTravel(list,root.left);
            list.add(root.val);
            BinaryTravel(list,root.right);
        }
    }
}

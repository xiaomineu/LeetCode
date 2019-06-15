package FlattenBinaryTreeToLinkedList;

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
public class flattenTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(6);
        flatten(root);
        System.out.println(root);
    }
    private static void flatten(TreeNode root){
        if(root==null){
            return;
        }
        List<TreeNode> list=new ArrayList<>();
        changeStruct(root,list);
        TreeNode curr=root;
        for(int i=1;i<list.size();i++){
            curr.right=list.get(i);
            curr.left=null;
            curr=curr.right;
        }
    }
    private static void changeStruct(TreeNode root,List<TreeNode> list){
        if(root==null){
            return;
        }
        list.add(root);
        changeStruct(root.left,list);
        changeStruct(root.right,list);
    }
}

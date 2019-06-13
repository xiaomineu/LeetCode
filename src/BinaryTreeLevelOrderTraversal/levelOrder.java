package BinaryTreeLevelOrderTraversal;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class levelOrder {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(level(root));
    }
    //The level traversal of Binary Tree
    //Using queue as a template
    private static List<List<Integer>> level(TreeNode root){
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode curr=root;
        ((LinkedList<TreeNode>) queue).add(curr);
        while(true){
            List<TreeNode> template=new ArrayList<>();
            while(!queue.isEmpty()){
                template.add(((LinkedList<TreeNode>) queue).poll());
            }
            if(template.size()==0){
                break;
            }
            List<Integer> integers=new ArrayList<>();
            for(TreeNode treeNode:template){
                integers.add(treeNode.val);
                if(treeNode.left!=null){
                    ((LinkedList<TreeNode>) queue).add(treeNode.left);
                }
                if(treeNode.right!=null){
                    ((LinkedList<TreeNode>) queue).add(treeNode.right);
                }
            }
            list.add(new ArrayList<>(integers));
        }
        return list;
    }
}

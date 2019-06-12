package ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}

public class isValidBST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(3);
        root.right.right=new TreeNode(6);
//        TreeNode root=new TreeNode(1);
//        root.right=new TreeNode(1);
        System.out.println(isValid(root));
    }
    //BST数组中序遍历是有序的
    //如果中序遍历无序，则不是BST
    private static boolean isValid(TreeNode root){
        if(root==null){
            return true;
        }
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode rear=root;
        while(rear!=null){
            stack.push(rear);
            rear=rear.left;
        }
        while(!stack.isEmpty()){
            rear=stack.pop();
            list.add(rear.val);
            rear=rear.right;
            while(rear!=null){
                stack.push(rear);
                rear=rear.left;
            }
        }
        int pointer=list.get(0);
        for(int i=1;i<list.size();i++){
            if(pointer>=list.get(i)){
                return false;
            }
            pointer=list.get(i);
        }
        return true;
    }
}

package BinarySearchTreeIterator;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
//中序遍历非递归实现;
public class BSTIterator {
    public static void main(String[] args) {

    }
    private Stack<TreeNode> template=new Stack<>();
    public BSTIterator(TreeNode root){
        pushAll(root);
    }
    public int next(){
        if(hasNext()){
            TreeNode curr=template.pop();
            pushAll(curr.right);
            return curr.val;
        }else
            return -1;
    }
    public boolean hasNext(){
        return !template.isEmpty();
    }
    private void pushAll(TreeNode root){
        while(root!=null){
            template.push(root);
            root=root.left;
        }
    }
}

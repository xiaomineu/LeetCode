package BinaryTreePostOrderTraversal;

import java.util.LinkedList;
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
public class postorder {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        System.out.println(postorderTraversal(root));
    }
    //后序遍历，使用递归对后序遍历遍历;
    private static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new LinkedList<>();
        if(root==null){
            return result;
        }
        postTraversal(root,result);
        return result;
    }
    private static void postTraversal(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        postTraversal(root.left,result);
        postTraversal(root.right,result);
        result.add(root.val);
    }
    //使用堆栈进行辅助进行遍历，遍历顺序是root,rightNode,leftNode;
    //将数值插入容器中，相当于对遍历进行reverse;
    //得到的结果为leftNode,rightNode,root,即为后序遍历;
    public List<Integer> post(TreeNode root){
        LinkedList<Integer> list=new LinkedList<>();
        Stack<TreeNode> template=new Stack<>();
        TreeNode curr=root;
        while(curr!=null||!template.isEmpty()){
            if(curr!=null){
                list.addFirst(curr.val);
                template.push(curr);
                curr=curr.right;
            }else{
                curr=template.pop();
                curr=curr.left;
            }
        }
        return list;
    }
}

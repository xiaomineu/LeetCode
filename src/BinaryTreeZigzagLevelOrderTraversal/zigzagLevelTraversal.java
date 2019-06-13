package BinaryTreeZigzagLevelOrderTraversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class zigzagLevelTraversal {
    public static void main(String[] args) {

    }
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=0;
        while(!queue.isEmpty()){
            int level=queue.size();
            List<Integer> template=new ArrayList<>();
            for(int i=0;i<level;i++){
                root=queue.poll();
                if(root.left!=null){
                    queue.offer(root.left);
                }
                if(root.right!=null){
                    queue.offer(root.right);
                }
                if(depth%2!=0){
                    template.add(0,root.val);//ArrayList.add方法中，有随机位置的插入方法;
                }else
                    template.add(root.val);
            }
            depth++;
            list.add(template);
        }
        return list;
    }
}

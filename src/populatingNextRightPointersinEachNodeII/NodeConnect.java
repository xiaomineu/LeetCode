package populatingNextRightPointersinEachNodeII;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node(){}
    public Node(int _val,Node _left,Node _right,Node _next){
        val=_val;
        left=_left;
        right=_right;
        next=_next;
    }
}
public class NodeConnect {
    public static void main(String[] args) {

    }
    private static Node connect(Node root){
        Queue<Node> queue=new LinkedList<>();
        if(root==null){
            return root;
        }
        Node curr=root;
        queue.add(curr);
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                curr=queue.poll();
                if(!queue.isEmpty()){
                    curr.next=queue.peek();
                }
                if(i==len-1){
                    curr.next=null;
                }
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }
}

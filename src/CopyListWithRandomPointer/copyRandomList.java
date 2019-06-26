package CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

class Node{
    public int val;
    public Node next;
    public Node random;
    public Node(){}
    public Node(int _val,Node _next,Node _random){
        val=_val;
        next=_next;
        random=_random;
    }
}
public class copyRandomList {
    public static void main(String[] args) {

    }
    private static Node CopyRandom(Node head){
        if(head==null){
            return head;
        }
        Node result=head;
        //使用hashMap实现原节点与拷贝节点的映射;
        Map<Node,Node> map=new HashMap<>();
        while(result!=null){
            Node clone=new Node(result.val,null,null);
            map.put(result,clone);
            result=result.next;
        }
        result=head;
        while(result!=null){
            map.get(result).next=map.get(result.next);
            map.get(result).random=map.get(result.random);
            result=result.next;
        }
        return map.get(head);
    }
}

package ReorderList;

import java.util.LinkedList;
import java.util.Stack;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}
public class reorderList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        reorder(head);
        System.out.println(head);
    }
    //定义快慢指针，找到中间节点;
    //从中间节点将节点依次入栈;
    private static void reorder(ListNode head){
        ListNode result=head;
        if(head==null){
            return;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Stack<ListNode> stack= new Stack<ListNode>();
        while(slow!=null){
            stack.push(slow);
            slow=slow.next;
        }
        while(true){
            if(!stack.isEmpty()){
                ListNode curr=stack.pop();
                curr.next=result.next;
                result.next=curr;
                result=curr.next;
                if(stack.isEmpty()){
                    result.next=null;
                    break;
                }
            }else break;
        }
    }
}

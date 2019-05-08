package swapNodes;

import java.util.List;
import java.util.Stack;

class ListNode{
    int value;
    ListNode next;
    ListNode(int x){
        value=x;
    }
}
public class swapNode {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        System.out.println(swapParies(listNode,3));
    }
    public static ListNode swapParies(ListNode head, int k){
        if(head==null||head.next==null){
            return head;
        }
        //使用堆栈
        Stack<ListNode> stack=new Stack<>();
        ListNode first=new ListNode(-1);
        ListNode rear=first;
        //带头结点链表插入
        while(head!=null||stack.size()==k)
        {
            if(stack.size()==k){
                while(!stack.isEmpty()){
                    rear.next=stack.pop();
                    rear=rear.next;
                }
            }else{
                stack.push(head);
                head=head.next;
            }
        }
        rear.next=null;
        while(!stack.isEmpty()){
            ListNode listNode=stack.pop();
            listNode.next=rear.next;
            rear.next=listNode;
        }
        return first.next;
    }
}

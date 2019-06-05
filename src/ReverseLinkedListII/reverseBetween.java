package ReverseLinkedListII;

import java.util.Stack;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}
public class reverseBetween {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode((2));
        head.next.next=new ListNode((3));
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println(reverse(head,3,4));
    }
    private static ListNode reverse(ListNode head,int m,int n){
        int count=n-m;
        if(count==0){
            return head;
        }
        //使用堆栈进行链表翻转
        Stack<ListNode> stack=new Stack<>();
        ListNode last=head;
        ListNode first=head;
        int i=1;
        while(i<m-1){
            first=first.next;
            last=last.next;
            i++;
        }
        //如果是头结点
        if(m!=1){
            last=last.next;
        }
        while(count>=0&&last!=null){
            stack.push(last);
            last=last.next;
            count--;
        }
        //头结点改变
        if(m==1){
            head=stack.pop();
            first=head;
        }
        while(!stack.isEmpty()){
            first.next=stack.pop();
            first=first.next;
        }
        first.next=last;
        return head;
    }
}

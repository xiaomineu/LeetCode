package swapNodes;

public class swapPariesUp {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        System.out.println(swap(listNode));
    }
    public static ListNode swap(ListNode head){
        //判断边界条件
        if(head==null||head.next==null){
            return head;
        }
        ListNode first=new ListNode(-1);
        ListNode r=first;
        first.next=head;
        while(first.next!=null&&first.next.next!=null){
            ListNode x=first.next;//1
            ListNode y=x.next.next;//3
            first.next=x.next;
            first.next.next=x;
            first.next.next.next=y;
            first=first.next.next;
        }
        return r.next;
    }
}

package InsertionSortList;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}
public class insertionSortList {
    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(4);
//        head.next.next.next=new ListNode(3);
        System.out.println(insertion(head));
    }
    //链表插入排序;
    private static ListNode insertion(ListNode head){
        if(head==null){
            return head;
        }
        ListNode newHead=new ListNode(head.val);
        ListNode curr=head.next;
        while(curr!=null){
            ListNode template=curr.next;
            if(curr.val<newHead.val){
                curr.next=newHead;
                newHead=curr;

            }else if(curr.val>=newHead.val){
                ListNode rear=newHead;
                while(rear.next!=null&&curr.val>rear.next.val){
                    rear=rear.next;
                }
                curr.next=rear.next;
                rear.next=curr;
            }
            curr=template;
        }
        return newHead;
    }
}

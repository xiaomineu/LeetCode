package RemoveDuplicate;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}

public class deleteDuplicates {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(3);
        System.out.println(deleteNode(head));
    }
    private static ListNode deleteNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode rear=head;
        ListNode curr=head.next;
        while(rear!=null&&curr!=null){
            if(rear.val==curr.val){
                rear.next=curr.next;
                curr=rear.next;
            }else{
                rear=rear.next;
                curr=curr.next;
            }
        }
        return head;
    }
}

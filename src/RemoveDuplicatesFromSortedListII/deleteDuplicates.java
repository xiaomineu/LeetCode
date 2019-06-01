package RemoveDuplicatesFromSortedListII;
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
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next.next=new ListNode(5);
        System.out.println(deleteDuplicates(head));
    }
    private static ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode rear=null;
        ListNode curr=head;
        while(curr!=null){
            if(curr.next!=null&&curr.val==curr.next.val){
                curr=curr.next;
                continue;
            }
            //rear==null并且curr!=head表示当前头结点重复
            //rear!=null并且rear.next!=curr表示curr所指为重复元素，需要跳过;
            if((rear!=null&&rear.next!=curr)||(rear==null&&curr!=head)) {
                if(rear==null) {
                    head=curr.next;
                    curr=curr.next;
                }else {
                    rear.next=curr.next;
                    curr=curr.next;
                }
            }
            //非重复元素，直接向后遍历
            else{
                rear=curr;
                curr=curr.next;
            }
        }
        return head;
    }
}

package LinkedListCycle;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}
public class hasCycle {
    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(-4);
        head.next.next.next.next=head.next;
        System.out.println(hasCycles(head));
    }
    //判断节点中是否有环;
    //建立快慢指针,当快慢指针相等时，则存在环
    private static boolean hasCycles(ListNode head){
        if(head==null){
            return false;
        }
        ListNode slow=head.next;
        if(slow!=null){
            ListNode fast=head.next.next;
            while(fast!=null&&fast.next!=null){
                if(slow==fast){
                    return true;
                }
                slow=slow.next;
                fast=fast.next.next;
            }
        }
        return false;
    }
}

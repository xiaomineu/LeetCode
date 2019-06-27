package LinkedListCycleII;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}
public class detectCycle {
    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(-4);
        head.next.next.next.next=head.next;
        System.out.println(detect(head));
    }
    //返回循环链表的循环节点
    //使用快慢指针进行判断是否有环
    //找出环节点入口
    //设：从head走到入口节点为a,环长度为b;

    /**
     * slow指针必然与fast指针相遇，并且，slow指针走的路长一定小于等于a+b，
     * fast指针，快慢指针相遇时，必然快指针走完一圈以上，设相遇时，fast走完m全环;
     * 所以：2(a+x)=a+mb+x
     * 化简得：x=mb-a;
     * 快指针与慢指针相遇时，head节点至环入口节点距离为a;
     * fast再走a步，总共走过距离为a+mb+x+a=2a+mb+x;
     * 将x代入得：a+2mb；
     * 此时，fast指针必然在环入口节点
     * 或者a+x+a=a+mb，此时slow指针也走完一圈，所以遍历a次，即为环入口节点;
     * @param head
     * @return
     */
    private static ListNode detect(ListNode head){
        if(head==null||head.next==null){
            return null;
        }
        ListNode mark=cycle(head);
        if(mark==null){
            return mark;
        }
        while(head!=mark){
            head=head.next;
            mark=mark.next;
        }
        return head;
    }
    private static ListNode cycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)return slow;
        }
        return null;
    }
}

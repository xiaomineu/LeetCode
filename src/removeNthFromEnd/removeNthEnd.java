package removeNthFromEnd;
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class removeNthEnd {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
//        listNode.next=new ListNode(2);
//        listNode.next.next=new ListNode(3);
//        listNode.next.next.next=new ListNode(4);
//        listNode.next.next.next.next=new ListNode(5);
        System.out.println(removeNode(listNode,1));
    }
    public static ListNode removeNode(ListNode head,int n){
        if(head==null){
            return null;
        }
        int size=1;
        ListNode r=head;
        while(r.next!=null){
            size++;
            r=r.next;
        }
        if(size<n){
            return head;
        }
        ListNode end=head;
        for(int i=1;i<n;i++){
            end=end.next;
        }
        ListNode rear=head;
        while(end.next!=null){
            rear=rear.next;
            end=end.next;
        }
        //删除节点,减少复杂度，将被删除节点替换
        //删除节点为尾节点,遍历寻找尾节点前一节点
        if(rear.next==null){
            //判断删除节点即是首节点，也是尾节点
            if(head==rear){
                return null;
            }
            ListNode before=head;
            while(before.next!=rear){
                before=before.next;
            }
            before.next=null;
        }else{
            rear.val=rear.next.val;
            rear.next=rear.next.next;
        }
        return head;
    }
}

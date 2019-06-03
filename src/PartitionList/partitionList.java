package PartitionList;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}
public class partitionList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);
        System.out.println(partition(head,3));
    }
    //因为java中无指针的指针的概念，所以应该采用头插法
    private static ListNode partition(ListNode head,int x){
        if(head==null||head.next==null){
            return head;
        }
        ListNode first=new ListNode(-1);
        ListNode rear_first=first;
        ListNode Second=new ListNode(-1);
        ListNode rear_second=Second;
        ListNode rear=head;
        while(rear!=null){
            if(rear.val<x){
                rear_first.next=rear;
                rear_first=rear_first.next;
            }else{
                rear_second.next=rear;
                rear_second=rear_second.next;
            }
            rear=rear.next;
            rear_first.next=null;
            rear_second.next=null;
        }
        rear_first.next=Second.next;
        return first.next;
    }
}

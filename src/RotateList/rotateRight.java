package RotateList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}

public class rotateRight {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        System.out.println(rotate(head,10));
    }
    private static ListNode rotate(ListNode head,int k){
        if(head==null||k==0){
            return head;
        }
        int length=0;
        ListNode rear=head;
        while(rear!=null){
            rear=rear.next;
            length++;
        }
        if(k%length==0){
            return head;
        }
        k=k%length;
        ListNode position=head;
        rear=head;
        for(int i=0;i<k;i++){
            position=position.next;
        }
        while(position.next!=null){
            position=position.next;
            rear=rear.next;
        }
        ListNode first=rear.next;
        rear.next=null;
        position.next=head;
        head=first;
        return head;
    }
}

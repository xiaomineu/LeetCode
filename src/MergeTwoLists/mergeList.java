package MergeTwoLists;



class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}

public class mergeList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        System.out.println(mergeTwoList(l1,l2));
    }
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode listNode=new ListNode(0);
        ListNode head=listNode;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val)
            {
                listNode.next=l1;
                l1=l1.next;
                listNode=listNode.next;
            }else{
                listNode.next=l2;
                l2=l2.next;
                listNode=listNode.next;
            }
        }
        while(l1!=null){
            listNode.next=l1;
            listNode=listNode.next;
            l1=l1.next;
        }
        while(l2!=null){
            listNode.next=l2;
            listNode=listNode.next;
            l2=l2.next;
        }
        return head.next;
    }
}

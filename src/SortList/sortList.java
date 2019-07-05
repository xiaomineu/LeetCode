package SortList;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}
public class sortList {
    public static void main(String[] args) {

    }
    //使用O(nlogn)复杂度对链表进行排序
    //使用归并排序
    private static ListNode ListSortNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode res=merge(curr);
        return res;
    }
    private static ListNode merge(ListNode left){
        if(left==null||left.next==null){
            return left;
        }
        ListNode mid=findMid(left);
        ListNode next=mid.next;
        mid.next=null;//将拆分后链表断开
        ListNode list1=merge(left);
        ListNode list2=merge(next);
        ListNode head=mergeTwoList(list1,list2);
        return head;
    }
    private static ListNode mergeTwoList(ListNode list1,ListNode list2){
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode head=null;
        if(list1.val<list2.val){
            head=list1;
            list1=list1.next;
        }else{
            head=list2;
            list2=list2.next;
        }
        ListNode cur=head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }else{
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        if(list1!=null)cur.next=list1;
        if(list2!=null)cur.next=list2;
        return head;
    }
    private static ListNode findMid(ListNode first){
        ListNode fast=first;
        ListNode slow=first;
        ListNode rear=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            rear=slow;
            slow=slow.next;
        }
        return rear;
    }
}

package InsersectionofTwoLinkedLists;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}
public class getInsertsectionNode {
    public static void main(String[] args) {

    }
    private static ListNode getInsertNode(ListNode headA,ListNode headB){
        if(headA==null||headB==null){
            return null;
        }
        int lengthA=0;
        int lengthB=0;
        ListNode rear=headA;
        while(rear!=null){
            lengthA++;
            rear=rear.next;
        }
        rear=headB;
        while(rear!=null){
            lengthB++;
            rear=rear.next;
        }
        if(lengthA>lengthB){
            int len=lengthA-lengthB;
            while(len>0){
                headA=headA.next;
                len--;
            }
        }else{
            int len=lengthB-lengthA;
            while(len>0){
                headB=headB.next;
                len--;
            }
        }
        while(headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}

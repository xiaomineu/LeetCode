package AddTwoSum.ReAddTwoSum;
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class AddNumber {
    public static void main(String[] args) {
        ListNode listNode01=new ListNode(2);
        listNode01.next=new ListNode(4);
        listNode01.next.next=new ListNode(3);
        ListNode listNode02=new ListNode(5);
        listNode02.next=new ListNode(6);
        listNode02.next.next=new ListNode(4);
        ListNode listNode=addTwoNumbers(listNode01,listNode02);
        System.out.println(listNode);
    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if(l1==null&&l2==null){
            return null;
        }
        int a=0;//数进位
        ListNode listNode=new ListNode(0);
        ListNode p=listNode;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                int element=l1.val+l2.val+a;
                if((element)>=10){
                    element%=10;
                    p.val=element;
                    a=1;
                }else{
                    p.val=element;
                    a=0;
                }
                l1=l1.next;
                l2=l2.next;
            }
            else if(l1!=null&&l2==null){
                int element=l1.val+a;
                if(element>=10){
                    element%=10;
                    p.val=element;
                    a=1;
                }else{
                    p.val=element;
                    a=0;
                }
                l1=l1.next;
            }
            else{
                int element=l2.val+a;
                if(element>=10){
                    element%=10;
                    p.val=element;
                    a=1;
                }else{
                    p.val=element;
                    a=0;
                }
                l2=l2.next;
            }
            if(l1!=null||l2!=null||a!=0){
                p.next=new ListNode(a);
                p=p.next;
            }
        }
        return listNode;
    }
}

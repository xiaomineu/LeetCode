package AddTwoSum;

import java.util.ArrayList;

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
public class addTwoSum {
    public static void main(String[] args) {
        ListNode listNode01=new ListNode(2);
        listNode01.next=new ListNode(4);
        listNode01.next.next=new ListNode(3);
        ListNode listNode02=new ListNode(5);
        listNode02.next=new ListNode(6);
        listNode02.next.next=new ListNode(4);
        ListNode listNode=add(listNode01,listNode02);
        System.out.println(listNode);
    }
    //默认初始值不为0
    public static ListNode add(ListNode a1,ListNode a2){
        if(a1==null&&a2==null){
            return null;
        }
        //使用两个数组存储两个链表的信息
        ArrayList<Integer> arrayList01=new ArrayList<>();
        ArrayList<Integer> arrayList02=new ArrayList<>();
        while(a1!=null||a2!=null){
            if(a1!=null){
                arrayList01.add(a1.val);
                a1=a1.next;
            }
            if(a2!=null){
                arrayList02.add(a2.val);
                a2=a2.next;
            }
        }
        int length01=arrayList01.size();
        int length02=arrayList02.size();
        //length为较小值
        int length=length01<length02?length01:length02;
        //lengthNum为较大值
        int lengthNum=length01>length02?length01:length02;
        int [] num=new int[lengthNum];
        int a=0;//进位的数
        int element;
        for(int i=length-1;i>0;i--){
            element=arrayList01.get(i)+arrayList02.get(i)+a;
            if(element>=10){
                element%=10;
                a=1;
            }else
                a=0;
            num[i]=element;
        }
        while(length<lengthNum){
            if(length01<length02){
                num[length]=arrayList02.get(length);
            }
            else
                num[length]=arrayList01.get(length);
            length++;
        }
        num[0]=arrayList01.get(0)+arrayList02.get(0)+a;
        ListNode head=null;
        head=list(num,num.length-1);
//        if(num[0]>10){
//            head.val=1;
//            num[0]%=10;
//            head.next=list(num,0);
//        }
//        else
//            head=list(num,0);
        return head;
    }

    public static ListNode list(int []num,int position){
        if(position<0){
            return null;
        }
        if(position==0){
            if(num[position]>=10){
                num[position]%=10;
                ListNode listNode=new ListNode(num[position]);
                listNode.next=new ListNode(1);
                return listNode;
            }
            else{
                ListNode listNode=new ListNode(num[position]);
                listNode.next=list(num,position-1);
                return listNode;
            }
        }
        ListNode listNode=new ListNode(num[position]);
        listNode.next=list(num,position-1);
        return listNode;
    }

}

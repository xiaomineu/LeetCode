package MergeKLists;

import java.util.TreeMap;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}

/**
 * 使用hashMap记录当前数字
 * 不重复：新建节点；
 * 重复，采用头插法，将结点插入
 * 遍历map中的value,获取节点，将结点连接起来（键值根据自然顺序排序）
 */
public class MergeKLists {
    public static void main(String[] args) {

    }
    public static ListNode mergeLists(ListNode[] lists){
        TreeMap<Integer,ListNode> treeMap=new TreeMap<>();
        ListNode listNode=new ListNode(-1);
        ListNode front=listNode;
        for(ListNode p:lists){
            while(p!=null){
                ListNode rear=p;
                p=p.next;
                if(!treeMap.containsKey(rear.val)){
                    treeMap.put(rear.val,rear);
                    rear.next=null;
                }else{
                    rear.next=treeMap.get(rear.val).next;
                    treeMap.get(rear.val).next=rear;
                }
            }
        }
        for(ListNode list:treeMap.values()){
            while(list!=null){
                listNode.next=list;
                list=list.next;
            }
        }
        return front.next;
    }
}

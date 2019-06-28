package LRUCache;

import java.util.Hashtable;

public class LRu {
    private LinkedNode head,tail;
    //哈希表+双向链表
    //哈希表完成查找的O(1);
    //添加还有删除，由双向链表维护;
    //head前端节点表示经常使用的，tail前结点表示不经常使用的;
    class LinkedNode{
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;
    }
    private void addNode(LinkedNode node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }
    private void removeNode(LinkedNode node){
        LinkedNode prev=node.pre;
        LinkedNode next=node.next;
        prev.next=next;
        next.pre=prev;
    }
    private void moveToHead(LinkedNode node){
        removeNode(node);
        addNode(node);
    }
    private LinkedNode popTail(){
        LinkedNode res=tail.pre;
        removeNode(res);
        return res;
    }
    private Hashtable<Integer,LinkedNode> cache=new Hashtable<>();
    private int size;
    private int capacity;
    public LRu(int capacity){
        this.size=0;
        this.capacity=capacity;
        head=new LinkedNode();
        tail=new LinkedNode();
        head.next=tail;
        tail.pre=head;
    }
    //find the node, move to head which means the high frequency;
    public int get(int key){
        LinkedNode node=cache.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }
    public void put(int key,int value){
        LinkedNode node=cache.get(key);
        if(node==null){
            LinkedNode newNode=new LinkedNode();
            newNode.key=key;
            newNode.value=value;
            cache.put(key,newNode);
            addNode(newNode);
            ++size;
            //the capacity not enough to put the new node,delete the lowest frequency node;
            if(size>capacity){
                LinkedNode tail=popTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value=value;//update the node value;
            moveToHead(node);
        }
    }
}

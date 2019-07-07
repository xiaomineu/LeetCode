package MinStack;
class Node{
    int val;
    Node next;
    public Node(int x){
        val=x;
    }
}
public class MinStack {
    private int max=Integer.MAX_VALUE;
    private Node head=null;
    public MinStack(){

    }
    public void push(int x){
        if(head==null){
            head=new Node(x);
        }else{
            Node rear=new Node(x);
            rear.next=head;
            head=rear;
        }
    }
    public void pop(){
        if(head==null){
            return;
        }
        head=head.next;
        max=Integer.MAX_VALUE;
    }
    public int top(){
        return head.val;
    }
    public int getMin(){
        Node curr=head;
        while(curr!=null){
            max=Math.min(max,curr.val);
            curr=curr.next;
        }
        return max;
    }

    public static void main(String[] args) {
        MinStack obj=new MinStack();
        obj.push(3);
        System.out.println(obj.top());
        obj.push(-1);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

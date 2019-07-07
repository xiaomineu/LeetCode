package MinStack;

import java.util.ArrayDeque;

public class StackMin {
    //使用Dequeue维持一个数字的最小堆;
    private final ArrayDeque<Integer> min=new ArrayDeque<>();
    private final ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
    private int minNumber;
    StackMin(){

    }
    public void push(int x){
        arrayDeque.push(x);
        if(min.isEmpty()||x<=min.peek()){
            minNumber=x;
            min.push(minNumber);
        }
    }
    public void pop(){
        //最小元素被抛出，次小存在于小根堆中的元素，一定也存在于堆栈中
        if(min.peek().equals(arrayDeque.peek())){
            min.pop();
            if(!min.isEmpty()){
                minNumber=min.peek();
            }
        }
        arrayDeque.pop();
    }
    public int top(){
        return arrayDeque.getFirst();
    }
    public int getMin(){
        return minNumber;
    }
}

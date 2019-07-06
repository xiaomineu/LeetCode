package EvaluateReversePolishNotation;

import java.util.Stack;

public class evalRPN {
    public static void main(String[] args) {
        String[] strings={"2", "1", "+", "3", "*"};
        System.out.println(eval(strings));
    }
    //逆波兰表达式
    //using stack
    private static int eval(String[] tokens){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("/")||tokens[i].equals("*")){
                int num2=stack.pop();
                int num1=stack.pop();
                stack.push(operation(num1,num2,tokens[i],stack));
            }else
                stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }
    private static int operation(int num1,int num2,String operate,Stack<Integer> stack){
        switch (operate){
            case "+":{
                return num1+num2;
            }
            case "-":{
                return num1-num2;
            }
            case "/":{
                return num1/num2;
            }
            case "*":{
                return num1*num2;
            }
        }
        return 0;
    }
}

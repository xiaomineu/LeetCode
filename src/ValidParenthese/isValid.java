package ValidParenthese;

import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        System.out.println(valid(")("));
    }
    public static boolean valid(String s){
        if(s==null||s.length()==1){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty()){
                    if(s.charAt(i)==')'){
                        if(stack.peek()=='('){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }else if(s.charAt(i)=='}'){
                        if(stack.peek()=='{'){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }else if(s.charAt(i)==']'){
                        if(stack.peek()=='['){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else
            return false;
    }
}

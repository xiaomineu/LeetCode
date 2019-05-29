package simplifyPath;

import java.util.Stack;

public class simplify {
    public static void main(String[] args) {
        String path="/a/../../b/../c//.//";
        System.out.println(simplifyPath(path));
    }
    //字符串按照/拆分为字符串数组
    //使用堆栈
    //遇到..将堆栈抛出
    //遇到.跳过
    private static String simplifyPath(String path){
        if(path==null){
            return "/";
        }
        Stack<String> stack=new Stack<>();
        for(String s:path.split("/")){
            if(s.equals(".")||s.isEmpty()){
                continue;
            }
            if(s.equals("..")){
                if(stack.size()>0){
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }
        if(stack.isEmpty()) return "/";
        return "/"+String.join("/",stack);
    }
}

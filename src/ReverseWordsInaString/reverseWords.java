package ReverseWordsInaString;

import java.util.LinkedList;
import java.util.List;

public class reverseWords {
    public static void main(String[] args) {
        String s="  hello world!  ";
        System.out.println(reverse(s));
    }
    private static String reverse(String s){
        String[] strings=s.split(" ");
        List<String> list=new LinkedList<>();
        for(String string:strings){
            if(string.equals("")){
                continue;
            }
            ((LinkedList<String>) list).push(string);
        }
        StringBuffer stringBuffer=new StringBuffer();
        while(!list.isEmpty()){
            stringBuffer.append(((LinkedList<String>) list).pop());
            if(list.size()!=0){
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }
}

package ExcelSheetColumnTitle;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class convertToTitle {
    public static void main(String[] args) {
        System.out.println(con(52));
    }
    private static String convert(int n){
        String s=new String();
        while(n>26){
            int temp=(n%26)==0?26:(n%26);
            char c=(char)(temp+64);
            n=(n-temp)/26;
            s=c+s;
        }
        return n>0?((char)(n+64)+s):s;
    }
    private static String con(int n){
        Map<Integer,Character> map=new HashMap<>();
        List<Character> list=new LinkedList<>();
        for(int i=1;i<=26;i++){
            char s= (char) ('A'+i-1);
            map.put(i,s);
        }
        while(n>26){
            int den=(n%26)==0?26:(n%26);//当余数为0时，数字应减去26,再进行循环;
            ((LinkedList<Character>) list).addFirst(map.get(den));
            n=(n-den)/26;
        }
        if(n>0){
            ((LinkedList<Character>) list).addFirst(map.get(n));
        }
        StringBuffer stringBuffer=new StringBuffer();
        for(Character character:list){
            stringBuffer.append(character);
        }
        return stringBuffer.toString();
    }
}

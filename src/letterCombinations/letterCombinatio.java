package letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinatio {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
    public static List<String> letterCombinations(String digits){
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> list=new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        StringBuilder stringBuilder=new StringBuilder(digits);
        Combaination(list,map,0,digits,stringBuilder);
        return list;
    }
    public static void Combaination(List<String> list,Map<Character,String>map,int index,String digits,StringBuilder stringBuilder){
        if(index==digits.length()){
            list.add(stringBuilder.toString());
            return;
        }
        String s=map.get(digits.charAt(index));
        for(int i=0;i<s.length();i++){
            stringBuilder.setCharAt(index,s.charAt(i));//setCharAt中index>count时，会出现越界异常
            Combaination(list,map,index+1,digits,stringBuilder);
        }
    }
}

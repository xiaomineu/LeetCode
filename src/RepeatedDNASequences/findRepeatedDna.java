package RepeatedDNASequences;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class findRepeatedDna {
    public static void main(String[] args) {
        String  s = "AAAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }
    private static List<String> findRepeatedDnaSequences(String s){
        List<String> result=new LinkedList<>();
        if(s==null||s.length()<10){
            return result;
        }
        HashSet<String> template=new HashSet<>();
        Set<String> set=new HashSet<>();
        template.add(s.substring(0,10));
        for(int i=1;i+10<=s.length();i++){
            String substring=s.substring(i,i+10);
            if(template.contains(substring)){
                if(!set.contains(substring)){
                    set.add(substring);
                }else
                    continue;
            }else
                template.add(substring);
        }
        result.addAll(set);
        return result;
    }
}

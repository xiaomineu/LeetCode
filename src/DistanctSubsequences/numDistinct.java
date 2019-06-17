package DistanctSubsequences;

import java.util.ArrayList;
import java.util.List;

public class numDistinct {
    public static void main(String[] args) {
        String s="dbaaadcddccdddcadacbadbadbabbbcad";
        String t="dadcccbaab";
        System.out.println(numDistincts(s,t));
    }

    /**
     * runtime limitted
     * 不可以使用宽搜进行
     * so the best solution is DP
     * @param s
     * @param t
     * @return
     */
    private static int numDistincts(String s,String t){
        List<String> list=new ArrayList<>();
        if(s==null||t==null){
            return 0;
        }
        StringBuilder template=new StringBuilder();
        Count(list,template,s,t,0);
        int num=0;
        for(String string:list){
            if(string.equals(t)){
                num++;
            }
        }
        return num;
    }
    private static void Count(List<String> list,StringBuilder template,String s,String t,int index){
        if(template.length()==t.length()){
            list.add(new String(template));
            return;
        }
        for(int i=index;i<s.length();i++){
            template.append(s.charAt(i));
            Count(list,template,s,t,i+1);
            template.deleteCharAt(template.length()-1);
        }
    }
}

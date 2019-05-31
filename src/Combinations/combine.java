package Combinations;

import java.util.ArrayList;
import java.util.List;

public class combine {
    public static void main(String[] args) {
        System.out.println(combination(4,2));
    }
    private static List<List<Integer>> combination(int n,int k){
        boolean[] flag=new boolean[n+1];
        List<Integer> template=new ArrayList<>();
        List<List<Integer>> list=new ArrayList<>();
        int index=1;
        listCombine(flag,list,template,index,k);
        return list;
    }
    private static void  listCombine(boolean [] flag,List<List<Integer>> list,List<Integer>template,int index,int k){
        if(template.size()==k){
            List<Integer> listInteger=new ArrayList<>(template);
            list.add(listInteger);
            return;
        }
        for(int i=index;i<flag.length;i++){
            if(!flag[i]){
                flag[i]=true;
                template.add(i);
                listCombine(flag,list,template,i+1,k);
                template.remove(template.size()-1);
                flag[i]=false;
            }
        }
    }
}

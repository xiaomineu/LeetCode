package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class generate {
    public static void main(String[] args) {
        System.out.println(triangle(5));
    }
    private static List<List<Integer>> triangle(int numRows){
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> template=new ArrayList<>();
        if(numRows<1){
            return list;
        }
        for(int i=0;i<numRows;i++){
            List<Integer> integers=new ArrayList<>();
            for(int j=0;j<=i;j++){

                if(j==0||j==i){
                    integers.add(1);
                }else{
                    integers.add(template.get(j-1)+template.get(j));
                }
            }
            template=integers;
            list.add(template);
        }
        return list;
    }
}

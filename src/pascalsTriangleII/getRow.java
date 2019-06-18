package pascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class getRow {
    public static void main(String[] args) {
        System.out.println(getRows(0));
    }
    private static List<Integer> getRows(int rowIndex){
        List<Integer> list=new ArrayList<>();
        if(rowIndex<0){
            return list;
        }
        for(int i=0;i<=rowIndex;i++){
            List<Integer> template=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    template.add(1);
                }else{
                    template.add(list.get(j-1)+list.get(j));
                }
            }
            list=template;
        }
        return list;
    }
}

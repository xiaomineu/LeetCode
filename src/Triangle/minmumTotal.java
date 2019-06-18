package Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minmumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        list.add(2);
        triangle.add(list);
        List<Integer> list1=new ArrayList<>();
        list1.add(3);
        list1.add(4);
        triangle.add(list1);
        List<Integer> list2=new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        triangle.add(list2);
        List<Integer> list3=new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        triangle.add(list3);
        System.out.println(minimumTotal(triangle));
    }

    //将上一层的数值累加值该层，然后选择最小值
    public static int minimumTotal(List<List<Integer>>triangle){
        if(triangle==null){
            return 0;
        }
        int len=triangle.size();
        if(len==1){
            return triangle.get(0).get(0);
        }
        int[] template=new int[len];
        for(int i=0;i<len;i++){
            List<Integer> list=triangle.get(i);
            int[] tem=new int[len];
            for(int j=0;j<=i;j++){
                if(j==0){
                    tem[j]=template[j]+list.get(j);
                }else if(j==i&&j!=0) {
                    tem[j] = template[j - 1] + list.get(j);
                }else{
                    int num=Math.min(template[j-1],template[j]);
                    tem[j]=list.get(j)+num;
                }
            }
            template=tem;
        }
        Arrays.sort(template);
        return template[0];
    }
}

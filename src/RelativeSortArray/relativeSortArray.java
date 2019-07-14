package RelativeSortArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class relativeSortArray {
    public static void main(String[] args) {
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2={2,1,4,3,9,6};
        System.out.println(relativeSortArray(arr1,arr2));
    }
    private static int[] relativeSortArray(int[] arr1,int[] arr2){
        //表示位置坐标;
        int[] template=new int[1001];
        //表示元素出现个数
        int[][] count=new int[arr2.length][2];
        for(int i=0;i<arr1.length;i++){
            template[arr1[i]]++;
        }
        for(int i=0;i<count.length;i++){
            count[i][0]=arr2[i];
            count[i][1]=template[arr2[i]];
            template[arr2[i]]=Integer.MAX_VALUE;
        }
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<count.length;i++){
            int num=count[i][1];
            while(num>0){
                list.add(count[i][0]);
                num--;
            }
        }
        Arrays.sort(arr1);
        for(int i=0;i<arr1.length;i++){
            if(template[arr1[i]]==Integer.MAX_VALUE){
                continue;
            }else
                list.add(arr1[i]);
        }
        int[] result=new int[list.size()];
        int index=0;
        for(Integer num:list){
            result[index++]=num;
        }
        return result;
    }
}

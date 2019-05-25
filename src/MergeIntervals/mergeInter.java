package MergeIntervals;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class mergeInter {
    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }

    /**
     * 使用Arrays进行排序
     * 二维数组中，以其中某一个进行位置元素进行排序
     * 使用lamda表达式
     * Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]))
     * a,b表示对象引用
     * @param intervals
     * @return
     */
    private static int[][] merge(int[][] intervals){
        if(intervals.length==0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list=new ArrayList<>();
        int minInterge=intervals[0][0];
        int maxInterge=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=maxInterge){
                minInterge=Math.min(intervals[i][0],minInterge);
                maxInterge=Math.max(intervals[i][1],maxInterge);
            }else{
                list.add(new int[]{minInterge, maxInterge});
                minInterge=intervals[i][0];
                maxInterge=intervals[i][1];
            }
        }
        list.add(new int[]{minInterge,maxInterge});
        int[][] ints=new int[list.size()][2];
        int index=0;
        for(int[] i:list){
            ints[index][0]=i[0];
            ints[index][1]=i[1];
            index++;
        }
        return ints;
    }
}

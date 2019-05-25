package InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insertInterval {
    public static void main(String[] args) {
        int[][] intervals={{}};
    }
    private int[][] insert(int[][] intervals,int[] newInterval){
        if(intervals.length==0){
            int[][] ints=new int[1][2];
            ints[0][0]=newInterval[0];
            ints[0][1]=newInterval[1];
            return ints;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]<newInterval[0]){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }else if(intervals[i][0]>newInterval[1]){
                list.add(new int[]{newInterval[0],newInterval[1]});
                newInterval[0]=intervals[i][0];
                newInterval[1]=intervals[i][1];
            }else if(intervals[i][0]<newInterval[1]||intervals[i][1]>newInterval[0]){
                newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);

            }
        }
        list.add(new int[]{newInterval[0],newInterval[1]});
        return list.toArray(new int[list.size()][2]);
    }
}

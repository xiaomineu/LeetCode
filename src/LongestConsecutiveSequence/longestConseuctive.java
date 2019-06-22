package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class longestConseuctive {
    public static void main(String[] args) {

    }
    //找到为排序的数组的最长子列长度，在O(n)算法内;
    private static int longest(int[] nums){
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int Max=0;
        for(int n:nums){
            int templateMax=1;
            while(set.contains(++n)){//判断下一个数是否存在于set中;
                templateMax++;
            }
            Max=Math.max(Max,templateMax);
        }
        return Max;
    }
}

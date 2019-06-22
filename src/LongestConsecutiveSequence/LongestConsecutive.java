package LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums={100,4,200,1,3,2};
        System.out.println(Longest(nums));
    }
    //如果数字不在hash表中，分别查看左右两个数字是否存在于hash表中，如果存在，返回表中映射值，不在返回0，将left+right+1作为当前映射，更新res结果;
    //并更新n-left，n+right的结果;
    private static int Longest(int[] nums){
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            if(map.containsKey(n))continue;
            int left=map.containsKey(n-1)?map.get(n-1):0;
            int right=map.containsKey(n+1)?map.get(n+1):0;
            int sum=left+right+1;
            map.put(n,sum);
            res=Math.max(res,sum);
            map.put(n-left,sum);
            map.put(n+left,sum);
        }
        return res;
    }
}

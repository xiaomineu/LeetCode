package TwoSum;

import java.util.HashMap;

public class twoSum {
    private int[] Sum(int[] nums,int target){
        int[] result=new int[2];
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                result[0]=hashMap.get(target-nums[i]);
                result[1]=i;
            }else
                hashMap.put(nums[i],i);
        }
        return result;
    }
}

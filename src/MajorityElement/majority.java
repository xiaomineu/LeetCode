package MajorityElement;

import java.util.Arrays;

public class majority {
    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    private static int majorityElement(int[] nums){
        Arrays.sort(nums);
        int len=nums.length;
        int element=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
                if(count>len/2){
                    element=nums[i];
                }
            }else
                count=1;
        }
        return element;
    }
    //长度大于nums.length/2;所以中间元素必然满足;
    private static int major(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

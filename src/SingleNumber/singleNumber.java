package SingleNumber;

import java.util.Arrays;

public class singleNumber {
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        System.out.println(single(nums));
    }
    private static int single(int[] nums){
        Arrays.sort(nums);
        int index=-1;
        for(int i=1;i<nums.length;i+=2){
            if(nums[i]!=nums[i-1]){
                index=i-1;
                break;
            }
        }
        return index==-1?nums[nums.length-1]:nums[index];
    }
}

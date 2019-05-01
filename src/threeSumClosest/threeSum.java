package threeSumClosest;

import java.util.Arrays;

public class threeSum {
    public static void main(String[] args) {
        int[] nums={1,2,4,8,16,32,64,128};
        System.out.println(threeSumClosest(nums,82));
    }
    public static int threeSumClosest(int [] nums,int target){
        //排序
        Arrays.sort(nums);
        /**
         * 1.排序
         * 2.设立三指针（l,rear,r)
         * 3.固定首尾指针，移动游标，求和，记录当前最小值
         */
        int length=nums.length;
        int min=nums[0]+nums[1]+nums[length-1];
        for(int i=0;i<length-2;i++){
            int j=i+1;
            int end=length-1;
            while(j<end){
                int sum=nums[i]+nums[j]+nums[end];
                if(sum>target){
                    end--;
                }else{
                    j++;
                }
                if(Math.abs(sum-target)<Math.abs(min-target)){
                    min=sum;
                }
            }
        }
        return min;
    }
}

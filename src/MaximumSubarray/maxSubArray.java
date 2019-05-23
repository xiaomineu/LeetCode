package MaximumSubarray;

public class maxSubArray {
    public static void main(String[] args) {
        int[] nums={-1,-2};
        System.out.println(maxSub(nums));
    }
    private static int maxSub(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int right=1;
        int MaxSum=nums[0];
        int sum=nums[0];
        while(right<nums.length){
            if(MaxSum<0){
                MaxSum=nums[right];
            }else{
                MaxSum=MaxSum+nums[right];
            }
            sum=Math.max(sum,MaxSum);
            right++;
        }
        return sum;
    }
}

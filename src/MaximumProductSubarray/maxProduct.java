package MaximumProductSubarray;

public class maxProduct {
    public static void main(String[] args) {
        int[] nums={-2,0,-1};
        System.out.println(maxProduce(nums));
    }
    //暴力求解，求解所有乘积，判断大小;
    private static int max=Integer.MIN_VALUE;
    private static int maxProduce(int[] nums){
        for(int i=0;i<nums.length;i++){
            int value=nums[i];
            int result=nums[i];
            for(int j=i+1;j<nums.length;j++){
                result=result*nums[j];
                value=Math.max(value,result);
            }
            max=Math.max(max,value);
        }
        return max;
    }
}

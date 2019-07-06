package MaximumProductSubarray;

public class Dp {
    public static void main(String[] args) {

    }
    //f(i)=max(nums[i],min_prev(i-1)*nums[i],max_prev(i-1)*nums[i])
    //使用dp
    //当前最大值为自身节点数值，前i-1序列中最大值与该点之积，前i-1序列中最小值与该点之积，三值之中最大值;
    private static int maxProduct(int[] nums){
        int max=Integer.MIN_VALUE;
        int max_product=1;
        int min_product=1;
        for(int val:nums){
            max_product*=val;
            min_product*=val;
            int max_temp=Math.max(max_product,Math.max(val,min_product));
            int min_temp=Math.min(max_product,Math.min(val,min_product));
            max_product=max_temp;
            min_product=min_temp;
            if(max_product>max){
                max=max_product;
            }
        }
        return max;
    }
}

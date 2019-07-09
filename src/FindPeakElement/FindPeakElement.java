package FindPeakElement;

public class FindPeakElement {
    public static void main(String[] args) {

    }
    //使用logn时间复杂度
    //使用二分法
    //重要数组中存在一个元素比相邻元素大，沿着该方向一定可以找到峰值
    //由于存在不止一个峰，通过二分法，如果mid>mid+1表示峰值在左侧，反之峰值在右侧;
    private static int findPeak(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[mid+1]){
                right=mid;
            }else
                left=mid+1;
        }
        return left;
    }
}

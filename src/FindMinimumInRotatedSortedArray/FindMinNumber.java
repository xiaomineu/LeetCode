package FindMinimumInRotatedSortedArray;

public class FindMinNumber {
    public static void main(String[] args) {

    }
    //使用O(logn)算法进行判断
    //使用二分法
    private int findMin(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return nums[left];
    }
}

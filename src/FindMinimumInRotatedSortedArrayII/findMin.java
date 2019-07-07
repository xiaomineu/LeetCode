package FindMinimumInRotatedSortedArrayII;

public class findMin {
    public static void main(String[] args) {
        int[] nums={2,2,2,0,1,1};
        System.out.println(findNumber(nums));
    }
    private static int findNumber(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[right]<nums[mid]){
                left=mid+1;
            }else if(nums[mid]<nums[left]){
                right=mid;
            }else
                right-=1;
        }
        return nums[left];
    }
}

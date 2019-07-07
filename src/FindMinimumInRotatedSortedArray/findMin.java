package FindMinimumInRotatedSortedArray;

public class findMin {
    public static void main(String[] args) {

    }
    //使用O(n)算法,遍历数组
    private static int find(int[] nums){
        int max=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.min(max,nums[i]);
        }
        return max;
    }
}

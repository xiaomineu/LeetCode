package searchInsertPosition;

public class searchInserPosition {
    public static void main(String[] args) {
        int[] nums={1,3,4,5,6};
        System.out.println(searchInsert(nums,7));
    }
    public static int searchInsert(int [] nums,int target){
        if(nums.length<=0){
            return -1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }
}

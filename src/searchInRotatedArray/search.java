package searchInRotatedArray;

public class search {
    public static void main(String[] args) {
        int[] list={7,8,9,2,3,4};
        System.out.println(Search(list,3));
    }

    /**
     * 类似于二分法查找
     * 但是该数组不是完全有序，只是部分有序
     * 1.找到转折点
     * 2.判断target与转折点关系，判断在哪个有序数组查找
     * 3.采用二分法查找，在有序数组中查找
     * @param nums
     * @param target
     * @return
     */
    public static int Search(int [] nums,int target){
        int start=0;
        int end=nums.length-1;
        if(start==end){
            if(target==nums[start]){
                return start;
            }else{
                return -1;
            }
        }
        while(start<end){
            if(target==nums[start]){
                return start;
            }
            if(target==nums[end]){
                return end;
            }
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            //mid位于第一个数组数组，并且target位于其中
            if(nums[mid]>target&&nums[start]<target){
                end=mid-1;
            }
            //mid位于第二个数组中，并且target位于第二个数组
            else if(nums[mid]<target&&nums[end]>target){
                start=mid+1;
            }
            //target位于第二数组中，mid位于第一个数组中
            else if(nums[start]>target&&nums[mid]>target){
                start++;
            }else{
                end--;
            }
        }
        return -1;
    }
}

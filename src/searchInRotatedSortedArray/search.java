package searchInRotatedSortedArray;
//不能使用排序数组，复杂度满足O(logn)

//对于翻转的有序数组，如果不含有重复元素，根据mid判断翻转位置，
// 判断哪一侧是递增的。
// 在判断target所在位置，选择下次查找的区间

public class search {
    public static void main(String[] args) {
        int[] nums={2,5,6,0,0,1,2};
        System.out.println(searchPosition(nums,5));
    }
    private static boolean searchPosition(int[] nums,int target){
        if(nums.length==0){
            return false;
        }
        int left=0;
        int right=nums.length-1;
        while(left+1<right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return true;
            }
            //判断哪一侧是递增
            //mid左侧是递增的
            if(nums[mid]>nums[left]||nums[right]<nums[mid]){
                //target在mid左侧
                if(nums[left]<=target&&target<nums[mid]){
                    right=mid;
                }else{
                    left=mid;
                }
            }
            //mid右侧递增
            else if(nums[mid]<nums[left]||nums[mid]<nums[right]){
                //target在mid右侧;
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid;
                }else{
                    right=mid;
                }
            }
            //中间元素与两边元素均相等，并且该元素不是target,删除该重复元素，缩小原数组长度
            else{
                --right;
            }
        }
        if(nums[left]==target||nums[right]==target){
            return true;
        }
        return false;
    }
}

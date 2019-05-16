package searchRange;

public class PositionSearchRange {
    public static void main(String[] args) {
        int[] nums={1,3};
        System.out.println(searchRange(nums,3));
    }
    public static int[] searchRange(int[] nums,int target){
        int [] range={-1,-1};
        if(nums.length<=0){
            return range;
        }
        int first=0;
        int end=nums.length-1;
        int mid=(end+first)/2;
        int index=-1;
        while(first<=end){
            if(nums[mid]<target){
                first=++mid;
                mid=(end+mid)/2;
            }else if(nums[mid]>target){
                end=--mid;
                mid=(first+mid)/2;
            }else{
                index=mid;
                break;
            }
        }
        if(index>0){
            while(index>0&&nums[index-1]==target){
                index--;
            }
        }
        range[0]=index;
        while(index<nums.length-1&&nums[index+1]==target){
            index++;
        }
        range[1]=index;
        return range;
    }
}

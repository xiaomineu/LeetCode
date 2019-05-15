package searchInRotatedArray;

public class search01 {
    public static void main(String[] args) {
        int[] list={7,8,9,2,3,4};
        System.out.println(search(list,3));
    }
    public static int search(int [] nums,int target){
        if(nums.length<=0) return -1;
        int start=0,end=nums.length-1;
        int mid=(start+end)/2;
        if(target==nums[start]) return start;
        if(target==nums[end]) return end;
        if(target==nums[mid]) return mid;
        while(start<end){
            if(target==nums[start]) return start;
            if(target==nums[end]) return end;
            if(target==nums[mid]) return mid;
            if(nums[end]>nums[mid]){
                if(nums[mid]<target&&nums[end]>target){
                    start=++mid;
                    mid=(start+mid)/2;
                }else{
                    end=--mid;
                    mid=(mid+start)/2;
                }
            }else{
                if(target<nums[mid]&&target>nums[start]){
                    end=--mid;
                    mid=(start+mid)/2;
                }else{
                    start=++mid;
                    mid=(mid+end)/2;
                }
            }
        }
        return -1;
    }
}

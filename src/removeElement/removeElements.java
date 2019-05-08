package removeElement;

public class removeElements {
    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        System.out.println(removeEle(nums,3));
    }
    public static int removeEle(int[] nums,int val){
        int newlength=nums.length;
        int length=0;
        for(int i=0;i<nums.length;i++){
            if(val==nums[i]){
                newlength--;
            }else{
                nums[length++]=nums[i];
            }
        }
        return newlength;
    }
}

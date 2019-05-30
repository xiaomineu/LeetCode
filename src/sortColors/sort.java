package sortColors;

public class sort {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(nums);
    }
    private static void sortColors(int[] nums){
        int count0=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count0++;
            }else if(nums[i]==1){
                count1++;
            }else{
                count2++;
            }
        }
        int index=0;
        for(int i=0;i<count0;i++){
            nums[index++]=0;
        }
        for(int i=0;i<count1;i++){
            nums[index++]=1;
        }
        for(int i=0;i<count2;i++){
            nums[index++]=2;
        }
    }
}

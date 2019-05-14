package NextPermutation;

import java.util.Arrays;

public class nextPermutation {
    public static void main(String[] args) {
        int[] nums={1,5,1};
        nextPermutationSolution(nums);
        System.out.println(nums.toString());
    }
    public static void swap(int left,int right,int[] nums){
        int template=nums[left];
        nums[left]=nums[right];
        nums[right]=template;
    }
    public static void nextPermutationSolution(int [] nums){
        if(nums.length==0||nums.length==1){
            return;
        }
        boolean flag=true;
        int i=nums.length-1;
        while(i>0){
            if(nums[i]>nums[i-1]){
                flag=false;
                break;
            }
            i--;
        }
        if(flag) {
            Arrays.sort(nums);
            return;
        }
        //交换边界位置
        int j=nums.length-1;
        while(j>i){
            if(nums[i-1]>=nums[j]){
                j--;
            }else{
                break;
            }
        }
        swap(i-1,j,nums);
        //如果都为逆序，则顺序排列
        Arrays.sort(nums,i,nums.length);
    }
}

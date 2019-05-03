package sumOfFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static void main(String[] args) {
        int[] nums={0,0,0,0};
        System.out.println(fourSum(nums,0));
    }
    public static List<List<Integer>> fourSum(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i==0||nums[i]!=nums[i-1]){
                for(int j=i+1;j<nums.length-2;j++){
                    if(j==i+1||j>0&&nums[j-1]!=nums[j]){
                        int end=nums.length-1;
                        int mid=j+1;
                        while(mid<end){
                            if(nums[i]+nums[j]+nums[mid]+nums[end]==target){
                                lists.add(Arrays.asList(nums[i],nums[j],nums[mid],nums[end]));
                                while(mid<end&&nums[mid]==nums[mid+1])mid++;
                                while(mid<end&&nums[end]==nums[end-1])end--;
                                mid++;
                                end--;
                            }else if(nums[i]+nums[j]+nums[mid]+nums[end]<target){
                                mid++;
                            }else{
                                end--;
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }
}

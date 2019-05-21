package PermutationsTwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permuteUnique {
    public static void main(String[] args) {
        int[] nums={1,1,2,2};
        System.out.println(unique(nums));
    }
    private static List<List<Integer>> unique(int[] nums){
        List<List<Integer>>list=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        unique(nums,0,list,set);
        return list;
    }
    private static void swap(int[] nums,int left,int right){
        int tem=nums[left];
        nums[left]=nums[right];
        nums[right]=tem;
    }
    private static void unique(int[] nums,int position,List<List<Integer>> list,Set<List<Integer>> set){
        //递归基
        if(position==nums.length-1){
            List<Integer> arrayList=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                arrayList.add(nums[i]);
            }
            if(set.add(arrayList)){
                list.add(arrayList);
            }
            return;
        }
        for(int i=position;i<nums.length;i++){
            swap(nums,i,position);
            unique(nums,position+1,list,set);
            swap(nums,i,position);
        }
    }
}

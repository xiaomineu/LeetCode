package permutations;

import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(permute(nums));
    }

    /**
     * 全排列
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> arrayList=new ArrayList<>();
        list(arrayList,nums,0);
        return arrayList;
    }
    private static void swap(int left,int right,int[] nums){
        int tem=nums[left];
        nums[left]=nums[right];
        nums[right]=tem;
    }
    private static void list(List<List<Integer>> arrayList,int[] nums,int position){
        if(position==nums.length-1){
            List<Integer> template=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                template.add(nums[i]);
            }
            arrayList.add(template);
            return;
        }
        for(int i=position;i<nums.length;i++){
            swap(position,i,nums);
            list(arrayList,nums,position+1);
            swap(position,i,nums);
        }
    }
}

package SubSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSets {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subsets(nums));
    }
    private static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> template=new ArrayList<>();
        Arrays.sort(nums);
        combine(nums,list,template,0);
        return list;
    }

    private static void combine(int[] nums,List<List<Integer>>list,List<Integer> template,int position){
        List<Integer> list1=new ArrayList<>(template);
        list.add(list1);
        for(int i=position;i<nums.length;i++){
                template.add(nums[i]);
                combine(nums,list,template,i+1);
                template.remove(template.size()-1);
            }
        }
}

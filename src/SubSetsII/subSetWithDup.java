package SubSetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetWithDup {
    public static void main(String[] args) {
        int[] nums={1,2,2};
        System.out.println(subSets(nums));
    }
    //如何避免重复元素的出现
    //在使用回溯法中，不会出现相同元素为入口的回溯
    private static List<List<Integer>> subSets(int[] nums){
        List<List<Integer>> list=new ArrayList<>();
        if(nums==null||nums.length==0){
            return list;
        }

        List<Integer> template=new ArrayList<>();
        Arrays.sort(nums);
        subWithDup(list,template,nums,0);
        return list;
    }
    private static void subWithDup(List<List<Integer>> list,List<Integer> template,int[] nums,int position){
        List<Integer> arrayList=new ArrayList<>(template);
        list.add(arrayList);
        for(int i=position;i<nums.length;i++){
            if(i>position&&nums[i]==nums[i-1]){
                continue;
            }
            template.add(nums[i]);
            subWithDup(list,template,nums,i+1);
            template.remove(template.size()-1);
        }
    }
}

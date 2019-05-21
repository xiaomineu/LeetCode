package PermutationsTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class permuteUnique {
    public static void main(String[] args) {
        int[] nums={1,1,2,2,2};
        System.out.println(unique(nums));
    }
    //{1,1,2,2},{1,2,1,2},{1,2,2,1},{2,1,1,2},{2,1,2,1},{2,2,1,1}

    /**
     * 全排列问题采用回溯法
     * 对于含有重复元素的数组，跳过重复元素
     * @param nums 已经排序好的数组
     * @return
     */
    private static List<List<Integer>> unique(int[] nums){
        List<List<Integer>>list=new ArrayList<>();
        boolean[] flag=new boolean[nums.length];
        List<Integer> tem=new ArrayList<>();
        Arrays.sort(nums);
        unique(nums,list,tem,flag);
        return list;
    }

    /**
     *
     * @param nums
     * @param list
     * @param template
     * @param flag  标记位：表示当前节点是否被访问,true表示当前数值已经进入arraylist中
     * last means that last visited Integer
     * num:this Integer
     * if(num!=last)
     * 如果元素相等，则不进行排列操作
     * 在一个循环中，相邻相等元素不能依次访问
     *  递归至position==n, (n,n-1)全排列，（n,n-1,n-2)全排列.....
     */
    private static void unique(int[] nums,List<List<Integer>> list,List<Integer> template,boolean[] flag){
        if(template.size()==nums.length){
            list.add(new ArrayList<>(template));
        }else{
            int last=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                int num=nums[i];
                if(!flag[i]&&num!=last){
                    last=nums[i];
                    flag[i]=true;
                    template.add(nums[i]);
                    unique(nums,list,template,flag);
                    flag[i]=false;
                    template.remove(template.size()-1);
                }
            }
        }
    }
}

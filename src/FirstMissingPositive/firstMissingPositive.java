package FirstMissingPositive;

public class firstMissingPositive {
    public static void main(String[] args) {
        int[] nums={1,2};
        System.out.println(firstMissing(nums));
    }
    public static int firstMissing(int[] nums){
        if(nums.length<=0){
            return 1;
        }
        /**
         * 只需要建立一个长度为nums.length+1的数组
         * 因为当nums中数组中数值大于该长度时，必然在1-nums.length范围中存在未出现数值
         * 注：
         *     当全部出现时，需要返回nums.length+1;
         */
        boolean [] template=new boolean[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<=nums.length){
                template[nums[i]]=true;
            }
        }
        int i=1;
        for(;i<template.length;i++){
            if(!template[i]){
                return i;
            }
        }
        return i;
    }
}

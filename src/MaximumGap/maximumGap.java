package MaximumGap;

import java.util.Arrays;

public class maximumGap {
    public static void main(String[] args) {
        int[] nums={100,3,2,1};
        System.out.println(maximum(nums));
    }
    //不符合题意，复杂度为nlogn;需要使用线性复杂度;
    public static int maximum(int[] nums){
        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int maxGap=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            maxGap=Math.max(maxGap,nums[i+1]-nums[i]);
        }
        return maxGap;
    }
    public int MaximumGap(int[] nums){
        if(nums.length<2){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        //最大值为max,最小值为min,若元素个数为N,最大间距不会小于(max-min)/nums.length,标记为gap;
        //数组元素隔gap分为一组，不需要考虑每组状况，只需要考虑组间间距即可;
        if(min==max)return 0;
        int gap=(max-min)/nums.length+1;
        int[][] bucks=new int[nums.length][];//使用桶排序，数组空间等于元素个数，桶容量等于元素个数；
        for(int i=0;i<nums.length;i++){//遍历元素，计算每个元素应该放置的位置;
            int b=(nums[i]-min)/gap;//数据应该放置在哪个桶中,数列最大值，最小值均分作桶；
            if(bucks[b]==null){
                bucks[b]=new int[]{nums[i],nums[i]};
            }else{
                //每个桶中只需要记录该桶的最大值以及最小值;
                bucks[b][0]=Math.min(bucks[b][0],nums[i]);//第一个元素放置最小值
                bucks[b][1]=Math.max(bucks[b][1],nums[i]);//第二个元素放置最大值
            }
        }
        int maxGap=Integer.MIN_VALUE;
        int previous=min;
        for(int i=0;i<nums.length;i++){//遍历所有桶,计算桶间的最大间距;
            if(bucks[i]==null)continue;
            maxGap=Math.max(maxGap,Math.max(bucks[i][0]-previous,bucks[i][1]-bucks[i][0]));//桶内间距，桶间间距最大值;
            previous=bucks[i][1];
        }
        return maxGap;
    }
}

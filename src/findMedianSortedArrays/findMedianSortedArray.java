package findMedianSortedArrays;

public class findMedianSortedArray {
    public static void main(String[] args) {
        int [] nums1={1,3};
        int [] nums2={2};
        System.out.println(findMedian(nums1,nums2));
    }
    public static double findMedian(int []nums1,int []nums2){
        //题目中假设两个数组均不为空
        //寻找中位数，两个数组，各有一个指针，每次将最小值放入辅助数组，中位数为辅助数组的中间字
        int lengths1= nums1.length;
        int lengths2=nums2.length;
        int[]template=new int[lengths1+lengths2];
        int n1=0;
        int n2=0;
        for(int i=0;i<template.length;i++){
            if(n1<lengths1&&n2<lengths2){
                if(nums1[n1]<nums2[n2]){
                    template[i]=nums1[n1++];
                }
                else{
                    template[i]=nums2[n2++];
                }
            }else if(n1==lengths1&&n2<lengths2){
                template[i]=nums2[n2++];
            }else{
                template[i]=nums1[n1++];
            }
        }
        if(template.length%2==0){
            double left=(double)template[template.length/2-1];
            double right=(double)template[template.length/2];
            return (left+right)/2;
        }else{
            return (double)template[template.length/2];
        }
    }
}

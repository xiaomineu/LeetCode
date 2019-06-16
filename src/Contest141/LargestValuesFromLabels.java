package Contest141;

import java.util.Arrays;
import java.util.Comparator;

public class LargestValuesFromLabels {
    public static void main(String[] args) {

    }
    private static int largestValuesFromLabel(int[] values,int[] labels,int num_wanted,int use_limit){
        int[][] template=new int[values.length][2];
        for(int i=0;i<template.length;i++){
            template[i]=new int[]{values[i],labels[i]};
        }
        Arrays.sort(template, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] f=new int[50000];//下标所对应的标签的个数
        int sum=0;
        int used=0;
        for(int i=values.length-1;i>=0;i--){
            if(used<num_wanted&&++f[template[i][1]]<=use_limit){
                sum+=template[i][0];
                used++;
            }
        }
        return sum;
    }
}

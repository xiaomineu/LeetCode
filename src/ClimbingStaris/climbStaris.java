package ClimbingStaris;

public class climbStaris {
    public static void main(String[] args) {
        System.out.println(climb(3));
    }
    //台阶问题，动态规划
    private static int climb(int n){
        int[] template=new int[n+1];
        if(n<=0){
            return 0;
        }
        template[0]=1;
        template[1]=1;
        for(int i=2;i<template.length;i++){
            template[i]=template[i-1]+template[i-2];
        }
        return template[n];
    }
}

package longestValidParenthes;

public class longestValid {
    public static void main(String[] args) {
        String s=")()())";
        System.out.println(longest(s));
    }
    public static int longest(String s){
        if(s.length()==0){
            return 0;
        }
        int [] template=new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                for(int j=i-1;j>=0;j--){
                    if(s.charAt(j)=='('&&template[j]!=1){
                        template[i]=1;
                        template[j]=1;
                        break;
                    }
                }
            }
        }
        int count=0;
        int max=0;
        for(int i=0;i<template.length;i++){
            if(template[i]==1){
                count++;
            }else{
                if(count>max){
                    max=count;
                }
                count=0;
            }
        }
        if(count>max){
            max=count;
        }
        return max;
    }
}

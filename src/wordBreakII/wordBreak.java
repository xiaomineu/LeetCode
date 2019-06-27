package wordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class wordBreak {
    public static void main(String[] args) {
        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict= Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(wordBreak(s,wordDict));
    }
    //DFS计算超时;
    //使用DFS+dp算法，对字符串进行判断，看是否可拆分,可拆分再进行判断;
    private static List<String> wordBreak(String s,List<String> wordDict){
        List<String> result=new ArrayList<>();
        if(s.isEmpty()||wordDict.isEmpty()){
            return result;
        }
        if(wordBreak_Check(s,wordDict)){
            List<String> template=new LinkedList<>();
            wordBreak(s,wordDict,result,template);
        }
        return result;
    }
    private static boolean wordBreak_Check(String s,List<String> wordDict){
        int maxWordLength=0;//字典中单词最大长度
        for(int i=0;i<wordDict.size();i++){
            maxWordLength=Math.max(maxWordLength,wordDict.get(i).length());
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<s.length()+1;i++){
            int x=i-maxWordLength>0?i-maxWordLength:0;
            for(int j=x;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){//s存在以第j位结尾的单词并截取第j位到i位的单词存在于字典中;
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    private static void wordBreak(String s,List<String> wordDict,List<String> result,List<String> template){
        if(s.isEmpty()){
            StringBuilder stringBuilder=new StringBuilder("");
            for(int i=0;i<template.size();i++){
                if(i==template.size()-1){
                    stringBuilder.append(template.get(i));
                }else
                    stringBuilder.append(template.get(i)+" ");
            }
            result.add(new String(stringBuilder));
        }else{
            for(int i=0;i<wordDict.size();i++){
              String currendWord=wordDict.get(i);
              if(s.indexOf(currendWord)==0){
                  template.add(currendWord);
                  String pre=s.substring(0,s.indexOf(currendWord));
                  String post=s.substring(s.indexOf(currendWord)+currendWord.length(),s.length());
                  String string=pre+post;
                  wordBreak(string,wordDict,result,template);
                  template.remove(template.size()-1);
              }
            }
        }
    }
}

package wordLadderII;

import java.util.*;

public class findLadder {
    public static void main(String[] args) {
        String beginWord="hit";
        String endWord="cog";
        String[] word={"hot","dot","dog","lot","log","cog"};
        List<String> wordList=Arrays.asList(word);
        System.out.println(find(beginWord,endWord,wordList));
    }
    //BFS+DFS
    //runtime limites
    private static List<List<String>> find(String beginWord,String endWord,List<String> wordList){
        List<List<String>> list=new ArrayList<>();
        List<String> template=new ArrayList<>();
        template.add(beginWord);
        for(String s:wordList){
            if(!s.equals(beginWord)){
                template.add(s);
            }
        }
        Map<String,Integer> map=new HashMap<>();
        Map<Integer,List<Integer>> neighbors=new HashMap<>();//创建邻接表;
        for(int i=0;i<template.size();i++){
            map.put(template.get(i),i);
            neighbors.put(i,new ArrayList<>());
        }
        int len=beginWord.length();
        for(int m=0;m<template.size();m++){
            for(int i=0;i<len;i++){
                char[] chars=template.get(m).toCharArray();
                for(char j='a';j<='z';j++){
                    chars[i]=j;
                    String s=new String(chars);
                    if(template.contains(s)&&m!= map.get(s)){
                        List<Integer> adjacent=neighbors.get(m);//获取该字符串位置
                        adjacent.add(map.get(s));//该位置字符串所连接的字符串的下标;
                    }
                }
            }
        }
        int end=template.indexOf(endWord);
        if(end==0||end==-1){
            return list;
        }
        Map<Integer,Integer> ladders=new HashMap<>();
        BFS(neighbors,ladders,end);
        List<String> solution=new ArrayList<>();
        DFS(template,neighbors,solution,list,ladders,0,end);
        return list;
    }
    //使用广度优先遍历创建邻接表
    private static void BFS(Map<Integer,List<Integer>>neighbors,Map<Integer,Integer> ladders,int end){
        Queue<Integer> queue=new LinkedList<>();
        boolean reached=false;
        queue.add(0);
        ladders.put(0,1);
        while(!reached&&!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Integer cur= queue.poll();
                if(cur==end){
                    reached=true;
                }
                for(Integer next:neighbors.get(cur)){
                    if(!ladders.containsKey(next)){
                        queue.add(next);
                        ladders.put(next,ladders.get(cur)+1);
                    }
                }
            }
        }
    }
    private static void DFS(List<String> template,Map<Integer,List<Integer>> neighbors,List<String> solution,List<List<String>> list,Map<Integer,Integer> ladders,int cur,int end){
        solution.add(template.get(cur));
        if(cur==end){
            list.add(new ArrayList<>(solution));
        }else{
            for(int next:neighbors.get(cur)){
                if(ladders.containsKey(next)&&ladders.get(next)==ladders.get(cur)+1){
                    DFS(template,neighbors,solution,list,ladders,next,end);
                }
            }
        }
        solution.remove(solution.size()-1);
    }
}

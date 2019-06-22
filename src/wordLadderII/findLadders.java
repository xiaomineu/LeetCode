package wordLadderII;

import java.util.*;

public class findLadders {
    public static void main(String[] args) {

    }
    private static List<List<String>> find(String beginWord,String endWord,List<String> wordList){
        Set<String> wordDict=new HashSet<>(wordList);
        List<List<String>> result=new LinkedList<>();
        Queue<List<String>> queue=new LinkedList<>();
        queue.offer(Arrays.asList(beginWord));
        wordDict.remove(beginWord);
        while(!queue.isEmpty()){
            int n=queue.size();
            Set<String> toRemove=new HashSet<>();
            for(int k=0;k<n;k++){
                List<String> path=queue.poll();
                String word=path.get(path.size()-1);
                char[] chars=word.toCharArray();
                for(int i=0;i<chars.length;i++){
                    char c=chars[i];
                    for(char ch='a';ch<='z';ch++){
                        if(c!=ch){
                            chars[i]=ch;
                            String nextWord=new String(chars);
                            if(wordDict.contains(nextWord)){
                                toRemove.add(nextWord);
                                List<String> newPath=new ArrayList<>(path);
                                newPath.add(nextWord);
                                queue.offer(newPath);
                                if(nextWord.equals(endWord)){
                                    result.add(newPath);
                                }
                            }
                        }
                    }
                    chars[i]=c;
                }
            }
            if(!result.isEmpty()){
                break;
            }
            if(!toRemove.isEmpty()){
                wordDict.removeAll(toRemove);
            }
        }
        return result;
    }
}

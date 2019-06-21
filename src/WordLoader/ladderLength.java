package WordLoader;

import java.util.*;

public class ladderLength {
    public static void main(String[] args) {

    }
    //BFS算法
    //每个字符串修改任意一种的结果与Set相比较，如果存在，以此字符串依次向下遍历;
    private static int ladder(String beginWord, String endWord, List<String>wordList){
        if(beginWord.equals(endWord)){
            return 1;
        }
        Set<String> dict=new HashSet<>(wordList);
        //使用队列进行BFS算法;使用二重循环建立邻接表;
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                char[] chars=queue.poll().toCharArray();
                for(int j=0;j<chars.length;j++){
                    char temp=chars[j];
                    for(char ch='a';ch<='z';ch++){
                        //构造新字符串，判断是否存在于集合中;
                        chars[j]=ch;
                        String result=new String(chars);
                        if(dict.contains(result)){
                            if(result.equals(endWord))return level+1;
                            queue.add(result);
                            dict.remove(result);
                        }
                    }
                    chars[j]=temp;
                }
            }
            level++;
        }
        return 0;
    }
}

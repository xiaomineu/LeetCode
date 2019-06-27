package WordBreak;

import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {

    }
    private static boolean  wordBreak(String s, List<String> wordDict){
        if(s==null||wordDict.isEmpty()){
            return false;
        }
        HashMap<String,Boolean> map=new HashMap<>();
        return wordBreak(s,wordDict,map);
    }
    //将字符串全部拆分为由数组中字符串组成;
    private static boolean wordBreak(String s,List<String> wordDict,HashMap<String,Boolean> map){
        if(s.isEmpty()){
            return true;
        }else{
            for(int i=0;i<wordDict.size();i++){
                String currend=wordDict.get(i);
                if(s.indexOf(currend)==0){
                    String pre=s.substring(0,s.indexOf(currend));
                    String post=s.substring(s.indexOf(currend)+currend.length(),s.length());
                    String string=pre+post;
                    //递归调用子串是否包含数组中的字符串;
                    if(!map.containsKey(string)){
                        map.put(string,wordBreak(string,wordDict,map));
                    }
                    boolean result=map.get(string);
                    if(result)return result;
                }
            }
            return false;
        }
    }
}

package lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Countnumber {
    public static void main(String[] args) {
        String s="abcabcau";
        int count=LengthOfLongestSubstring(s);
        System.out.println(count);
    }
    public static int LengthOfLongestSubstring(String s){
        Set<Character> characterSet=new HashSet<>();
        if(s.length()==0||s.length()==1){
            return s.length();
        }
        char []list=s.toCharArray();
        int i=0;
        int j=0;
        int max=0;
        while(j<list.length){
            //判断set中是否有该元素，没有该元素，加入
            if(characterSet.contains(list[j])==false){
                characterSet.add(list[j++]);
                max=Math.max(max,characterSet.size());
            }else{
                //当前set中含有该元素，遍历删除该元素以及该元素序列之前的所有元素
                characterSet.remove(list[i++]);
            }
        }
        return max;
    }
}

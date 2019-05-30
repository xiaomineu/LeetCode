package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class minString {
    public static void main(String[] args) {
        String s="aa";
        String t="aa";
        System.out.println(minWindow(s,t));
    }
    private static String minWindow(String s,String t){
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character,Integer> list=new HashMap<>();
        //使用左右指针记录当前指向元素
        int left=0;
        int right=0;
        int length=0;
        int[] index=new int[3];
        index[0]=-1;
        index[1]=0;
        index[2]=0;
        while(right<s.length()){
            list.put(s.charAt(right),list.getOrDefault(s.charAt(right),0)+1);
            if(map.containsKey(s.charAt(right))&&list.get(s.charAt(right)).intValue()==map.get(s.charAt(right)).intValue()){
                length++;
            }
            //移动左指针直到当前区间字符串不在满足要求时(种类数不满足)，继续移动右指针
            while(left<=right&&length==map.size()){
                //记录当前子字符串长度以及左右指针位置（只记录最小长度对应位置）
                if(index[0]==-1||right-left+1<index[0]){
                    index[0]=right-left+1;
                    index[1]=left;
                    index[2]=right;
                }
                //删除当前左指针指向的字符
                list.put(s.charAt(left),list.get(s.charAt(left))-1);
                //判断模板map中是否包含当前左指针指向字符，以及判断包含个数是否相等，若相等，继续移动左指针
                if(map.containsKey(s.charAt(left))&&list.get(s.charAt(left)).intValue()<map.get(s.charAt(left)).intValue()){
                    length--;
                }
                left++;
            }
            right++;
        }
        return index[0]==-1?"":s.substring(index[1],index[2]+1);
    }
}

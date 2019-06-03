package ScreamableString;

public class isScreamable {
    public static void main(String[] args) {
        String s1="great";
        String s2="rgeat";
        System.out.println(isScream(s1,s2));
    }
    //好吧，这道题我不会
    //我本想用hashMap来做，但是发现复杂度过高，每次需要统计新的
    //所以我参考了一下大神的答案
    //使用数组统计频率，下标表示是什么字符

    /**
     * 递归判断子字符串是否相等
     * 因为会调换位置
     * 所以需要两次判断
     * 判断（0,i)或者(length-i);
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isScream(String s1,String s2){
        if(s1.equals(s2)){
            return true;
        }
        int[] s1Char=new int[26];
        int[] s2Char=new int[26];
        for(int i=0;i<s1.length();i++){
            s1Char[s1.charAt(i)-'a']++;
            s2Char[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<s1Char.length;i++){
            if(s1Char[i]!=s2Char[i]){
                return false;
            }
        }
        for(int i=1;i<s1.length();i++){
            if(isScream(s1.substring(0,i),s2.substring(0,i))&&isScream(s1.substring(i),s2.substring(i))){
                return true;
            }
            if(isScream(s1.substring(0,i),s2.substring(s1.length()-i))&&isScream(s1.substring(i),s2.substring(0,s1.length()-i))){
                return true;
            }
        }
        return false;
    }
}

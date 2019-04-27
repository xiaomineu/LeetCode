package RegularExpressionMatching;
/**
 * 正则表达式匹配
 * 剑指offer有类似例题
 * 解题思路：
 *      '.'匹配任意字符
 *      '*'表示之前字符出现0-n次均可以
 *      回溯法
 * 1.s与p当前元素不论是否相等，s游标保持不变，遍历p,判断p当前元素后是否有'*’,判断至*，s的游标需要置为元素下一位
 * 3.p当前元素为'.'，s与p下标向后移动一位，如果p下一位为'*'，则直接返回true;
 */
public class isMatch01 {
    public static void main(String[] args) {
        System.out.println(isMatch("aaa","ab*ac*a"));
    }
    public static boolean isMatch(String s,String p){
        if(s==null||p==null){
            return false;
        }
        return match(s,p,0,0);
    }
    public static boolean match(String s,String p,int sp,int pp){
        if(sp==s.length()&&pp==p.length()){
            return true;
        }
        //模式串到边界，字符串未到边界
        if(sp!=s.length()&&pp==p.length()){
            return false;
        }
        //字符串到边界，模式串未到边界
        if(pp!=p.length()&&sp==s.length()){
            if(pp+1<p.length()&&p.charAt(pp+1)=='*'){
                return match(s,p,sp,pp+2);
            }else{
                return false;
            }
        }
        //模式串第二个字符为'*'时，并且不只剩1个字符
        if(pp<p.length()-1&&p.charAt(pp+1)=='*'){
            if(s.charAt(sp)==p.charAt(pp)||p.charAt(pp)=='.'){
                return match(s,p,sp+1,pp+2)||match(s,p,sp,pp+2)||match(s,p,sp+1,pp);
            }else{
                return match(s,p,sp,pp+2);//重复0次
            }
        }
        //模式串第二个字符不是'*'
        if(sp<s.length()&&s.charAt(sp)==p.charAt(pp)||p.charAt(pp)=='.'){
            return match(s,p,sp+1,pp+1);
        }
        return false;
    }
}

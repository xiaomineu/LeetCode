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
public class isMatch {
    public static void main(String[] args) {
        System.out.println(isMatchExpression("aaa","a*"));
    }
    public static boolean isMatchExpression(String s,String p){
        if(s.isEmpty()&&p.isEmpty()) {
            return true;
        }else if(!s.isEmpty()&&p.isEmpty()){
            return false;
        }
        return match(s,p,0,0);
    }
    public static boolean match(String s,String p,int sp,int pp){
        if(sp==s.length()&&pp==p.length()){
            return true;
        }
        if(sp!=s.length()&&pp==p.length()){
            return false;
        }
        if(pp<p.length()){
            if(sp==s.length()){
                return false;
            }
            if (s.charAt(sp) == p.charAt(pp)) {
                return match(s,p,sp+1,pp+1)||match(s,p,sp,pp+1);
            }else if(pp<p.length()-1&&p.charAt(pp+1)=='*'&&p.charAt(pp)=='.'){
                return true;
            }else if(pp<p.length()-2&&p.charAt(pp+1)=='*'){
                return match(s,p,sp,pp+2);
            }else if(p.charAt(pp)=='.'){
                return match(s,p,sp+1,pp+1);
            }
        }
        return false;
    }
}

package wildCardMatching;

public class isMatch {
    public static void main(String[] args) {
        System.out.println(match("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba","a*******b"));
    }

    public static boolean match(String s, String p) {
        return judge(s, p, 0, 0);
    }
    //单纯递归空间复杂度较大，无法ac
    private static boolean judge(String s, String p, int sIndex, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (sIndex != s.length() && pIndex == p.length()) {
            return false;
        }
        //字符串到边界，模式串未到边界
        if (sIndex == s.length() && pIndex != p.length()) {
            if (p.charAt(pIndex) == '*') {
                return judge(s, p, sIndex, pIndex + 1);
            } else {
                return false;
            }
        }
        //两者都未到边界
        if (p.charAt(pIndex) == '*') {
            return judge(s, p, sIndex, pIndex + 1) || judge(s, p, sIndex + 1, pIndex);
        }
        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
                return judge(s, p, sIndex + 1, pIndex + 1);
        }
        return false;
    }
}

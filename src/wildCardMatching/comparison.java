package wildCardMatching;

public class comparison {
    public static void main(String[] args) {
        System.out.println(isMatch("aaaa","****a"));
    }
    private static boolean isMatch(String s,String p){
        int sIndex=0,pIndex=0,match=0,startIndex=-1;
        while(sIndex<s.length()){
            if(pIndex<p.length()&&(p.charAt(pIndex)=='?'||s.charAt(sIndex)==p.charAt(pIndex))){
                sIndex++;
                pIndex++;
            }else if(pIndex<p.length()&&p.charAt(pIndex)=='*'){
                startIndex=pIndex;
                match=sIndex;
                pIndex++;
            }
            //match表示当前已匹配字符个数
            else if(startIndex!=-1){
                pIndex=startIndex+1;
                match++;
                sIndex=match;
            }
            else return false;
        }
        while(pIndex<p.length()&&p.charAt(pIndex)=='*'){
            pIndex++;
        }
        return pIndex==p.length();
    }
}

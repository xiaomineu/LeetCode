package DecodeWays;

public class numDeecoding {
    public static void main(String[] args) {
        String s="12";
        System.out.println(numDecoding(s));
    }

    /**
     * DP思想
     * 类似于台阶问题
     * 因为考虑0元素影响
     * 前一元素为0时，当前个数为0;
     * 前一元素不为0时，当前个数为前一个数与前两数个数之和（判断二位数是否满足)
     * @param s
     * @return
     */
    private static int numDecoding(String s){
        if(s.equals("0")||s.length()==0){
            return 0;
        }
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)!=0?1:0;
        for(int i=2;i<s.length();i++){
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
                int val=Integer.valueOf(s.substring(i-2,i));
                if(val>=10&&val<26){
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
}

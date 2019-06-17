package DistanctSubsequences;

public class numDistinctDP01 {
    public static void main(String[] args) {
        String s="rabbbit";
        String t="rabbit";
        System.out.println(num(s,t));
    }
    private static int num(String s,String t){
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        if(m<n){
            return 0;
        }
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j==0){
                    dp[i][j]=1;
                }else if(i<j){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j];//字符不相等，抛弃当前字符
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]+=dp[i-1][j-1];//字符相等，变换方法等于保留该字母的变换方法加上不用这个字母的变换方法（抛弃当前字符）
                    }
                }
            }
        }
        return dp[m][n];
    }
}

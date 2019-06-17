package DistanctSubsequences;

public class numDistinctDP {
    public static void main(String[] args) {
        String s="rabbbit";
        String t="rabbit";
        System.out.println(num(s,t));
    }
    private static int num(String s,String t){
        int m=s.length();
        int n=t.length();
        int[] f=new int[n+1];
        f[0]=1;
        for(int i=1;i<=m;++i){
            for(int j=n;j>=1;--j){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    f[j]+=f[j-1];
                }
            }
        }
        return f[n];
    }
}

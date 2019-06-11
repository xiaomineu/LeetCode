package InterleavingString;

public class isInterleave {
    public static void main(String[] args) {
        String s1="a";
        String s2="";
        String s3="a";
        System.out.println(isInter(s1,s2,s3));
    }

    /**
     * DP算法
     * 状态转移方程：
     * 建立二维数组，长度为两字符串长度
     * 交织字符串即为从数组左上角运行至右下角过程
     * 边界条件：
     * 00时，为true;
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    private static boolean isInter(String s1,String s2,String s3){
        int lengths1=s1.length();
        int lengths2=s2.length();
        boolean[][] flag=new boolean[lengths1+1][lengths2+1];
        if(lengths1+lengths2!=s3.length()){
            return false;
        }else if(lengths1+lengths2==0&&s3.length()==0){
            return true;
        }else{
            for(int i=0;i<=s1.length();i++){
                for(int j=0;j<=s2.length();j++){
                    if(i==0&&j==0){
                        flag[i][j]=true;
                    }
                    else if(i==0){
                        flag[i][j]=(flag[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
                    }else if(j==0){
                        flag[i][j]=(flag[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1));
                    }else{
                        flag[i][j]=(flag[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(flag[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
                    }
                }
            }
            return flag[s1.length()][s2.length()];
        }
    }
}

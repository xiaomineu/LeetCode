package EditDistance;

public class minDistance {
    public static void main(String[] args) {
        String word1="intention";
        String word2="execution";
        System.out.println(minNumber(word1,word2));
    }

    /**
     * DP中，当前状态是由前一状态演化而来，并且前一状态是当前已知的
     * 创建template[len+1][len2+1]数组，记录从word1中前i个字符----》word2中前j个字符所需要的最小操作数
     * @param word1
     * @param word2
     * @return
     */
    private static int minNumber(String word1,String word2){
        int len01=word1.length();
        int len02=word2.length();
        int[][] template=new int[len01+1][len02+1];
        //表示前word1中，前i个字符变为0个字符最小操作数为i;
        for(int i=0;i<=len01;i++){
            template[i][0]=i;
        }
        //表示前word1中，前0个字符变为i个字符最小操作数为i;
        for(int i=0;i<=len02;i++){
            template[0][i]=i;
        }
        for(int i=1;i<=len01;i++){
            for(int j=1;j<=len02;j++){
                //word1在i-1位置字符与word2在j-1字符相等，不需要转换
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    template[i][j]=template[i-1][j-1];
                }
                //不想等，比较三种操作次数
                else{
                    int add=template[i][j-1]+1;
                    int delete=template[i-1][j]+1;
                    int update=template[i-1][j-1]+1;
                    template[i][j]=Math.min(Math.min(add,delete),update);
                }
            }
        }
        return template[len01][len02];
    }
}

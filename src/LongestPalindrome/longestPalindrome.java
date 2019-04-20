package LongestPalindrome;


public class longestPalindrome {
    public static void main(String[] args) {
        String s="ccc";
        System.out.println(longestString(s));
    }
    //动态规划
    /*
    1.建立length*length的boolean[][]数组
    2.数组下标表示i-j的字符串是否为回文数,当i==j时，表示字符与自身互为回文数
    3.两个for循环遍历i,j下标对应的字符是否相等，若相等，判断当前boolean[i+1][j-1]是否显示子序列为回文数，
    若子序列为回文数，则此序列为回文数，数组记录为true,动规递增序列长度
     */
    public static String longestString(String s){
        if(s==null){
            return null;
        }
        if(s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        boolean [][]template=new boolean[s.length()][s.length()];
        String string=null;
        int max=0;
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                if(i==j){
                    template[i][j]=true;
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1){
                        template[i][j]=true;
                        if(max<2){
                            string=s.substring(i,j+1);
                        }
                    }
                    else if(template[i+1][j-1]){
                        template[i][j]=true;
                        if(max<j-i+1){
                            string=s.substring(i,j+1);
                            max=j-i+1;
                        }

                    }else{
                        template[i][j]=false;
                    }
                }
                else{
                    template[i][j]=false;
                }
            }
        }
        if(string==null){
            string=s.substring(0,1);
        }
        return string;
    }
}

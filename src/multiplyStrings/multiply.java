package multiplyStrings;

public class multiply {
    public static void main(String[] args) {
        String num1="0";
        String num2="0";
        System.out.println(multi(num1,num2));
    }
    //乘法运算，num1[i]与num2[j]乘法中，结果位于i+j以及i+j+1的位置中

    /*
    注意事项：
        遍历顺序由后向前，减少进位之后，前一位越界
     */
    public static String multi(String num1,String num2){
        if(num1==null||num2==null){
            return null;
        }
        int [] template=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>-1;i--){
            for(int j=num2.length()-1;j>-1;j--){
                int position=i+j;
                int pos=i+j+1;
                int sum=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+template[pos];
                template[pos]=sum%10;
                template[position]+=sum/10;
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        for(int p:template){
            if(!(stringBuffer.length()==0&&p==0)){
                stringBuffer.append(p);
            }
        }
        return stringBuffer.length()==0?"0":stringBuffer.toString();
    }
}

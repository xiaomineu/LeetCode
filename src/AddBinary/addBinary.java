package AddBinary;

import java.math.BigInteger;

public class addBinary {
    public static void main(String[] args) {
        System.out.println(add("11","1"));
    }
    private static String add(String a,String b){
//        return (new BigInteger(a,2).add(new BigInteger(b,2))).toString(2);
        int aLen=a.length()-1;
        int blen=b.length()-1;
        String s="";
        int sum=0;
        while(aLen>=0||blen>=0||sum>0){
            sum+=(aLen>=0?a.charAt(aLen)-'0':0);
            sum+=(blen>=0?b.charAt(blen)-'0':0);
            s=(char)(sum%2+'0')+s;
            sum/=2;
            aLen--;
            blen--;
        }
        return s;
    }
}

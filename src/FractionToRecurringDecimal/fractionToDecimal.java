package FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class fractionToDecimal {
    public static void main(String[] args) {
        int numerator=-1;
        int denmoinator=-2147483648;
        System.out.println(fractionToDecimal(numerator,denmoinator));
    }
    public static String fractionToDecimal(int numerator,int denominator){
        if(numerator==0){
            return "0";
        }
        StringBuffer result=new StringBuffer("");
        if((numerator<0&&denominator>0)||(numerator>0&&denominator<0)){
            result.append("-");
        }
        long num=numerator;
        long den=denominator;
        num=Math.abs(num);
        den=Math.abs(den);
        result.append(num/den);
        num=num%den;
        if(num==0){
            return result.toString();
        }
        result.append(".");
        num*=10;
        Map<Long,Integer> map=new HashMap<>();
        while(num!=0){
            //nums重复出现，表示小数部分重复出现数字,将其用括号括起来;
            if(map.containsKey(num)){
                int index=map.get(num);
                result.insert(index,"(");
                result.append(")");
                return result.toString();
            }
            map.put(num,result.length());
            long res=num/den;
            result.append(String.valueOf(res));
            num=(num%den)*10;
        }
        return result.toString();
    }
}

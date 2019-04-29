package romanToInt;

import java.util.HashMap;
import java.util.Map;

public class romanTo {
    public static void main(String[] args) {
        String s="MCMXCIV";
        System.out.println(convertInt(s));
    }
    public static int convertInt(String s){
        if(s==null||s==""){
            return 0;
        }
        Map<Character,Integer> map=new HashMap();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int i=0;
        int sum=0;
        for(;i<s.length()-1;i++){
            if(s.charAt(i)=='C'&&s.charAt(i+1)=='M'){
                sum=sum+map.get('M')-map.get('C');
                i++;
            }else if(s.charAt(i)=='C'&&s.charAt(i+1)=='D'){
                sum=sum+map.get('D')-map.get('C');
                i++;
            }else if(s.charAt(i)=='X'&&s.charAt(i+1)=='C'){
                sum=sum+map.get('C')-map.get('X');
                i++;
            }else if(s.charAt(i)=='X'&&s.charAt(i+1)=='L'){
                sum=sum+map.get('L')-map.get('X');
                i++;
            }else if(s.charAt(i)=='I'&&s.charAt(i+1)=='X') {
                sum = sum + map.get('X') - map.get('I');
                i++;
            }else if(s.charAt(i)=='I'&&s.charAt(i+1)=='V'){
                sum=sum+map.get('V')-map.get('I');
                i++;
            }else{
                sum+=map.get(s.charAt(i));
            }
        }
        if(i==s.length()-1){
            sum+=map.get(s.charAt(i));
        }
        return sum;
    }
}

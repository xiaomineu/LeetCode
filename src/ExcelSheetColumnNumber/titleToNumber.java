package ExcelSheetColumnNumber;

import java.util.HashMap;
import java.util.Map;

public class titleToNumber {
    public static void main(String[] args) {
        System.out.println(titleNumber("AAZ"));
    }
    private static int titleNumber(String s){
        Map<Character,Integer> map=new HashMap<>();
        for(int i=1;i<=26;i++){
            map.put((char)('A'+i-1),i);
        }
        int count=0;
        int sum=0;
        for(int i=s.length()-1;i>=0;i--){
            sum+=map.get(s.charAt(i))*Math.pow(26,count);
            count++;
        }
        return sum;
    }
    private static int title(String s){
        int ans=0;
        char[] chars=s.toCharArray();
        int len= chars.length;
        for(int i=0;i<len;i++){
            ans+=(int)Math.pow(26,len-1-i)*(chars[i]-'A'+1);
        }
        return ans;
    }
}

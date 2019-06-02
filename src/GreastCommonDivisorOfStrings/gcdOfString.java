package GreastCommonDivisorOfStrings;

public class gcdOfString {
    public static void main(String[] args) {
        String str1="ABABAB";
        String str2="AB";
        System.out.println(gcdOf(str1,str2));
    }
    private static String gcdOf(String str1,String str2){
        if(str1.length()>str2.length()){
            String[] template=str1.split(str2);
            if(template.length==0){
                return str2;
            }
            int len=str2.length()/2;
            while(len>1){
                String s=str2.substring(0,len);
                if(str2.split(s).length==0&&str1.split(s).length==0){
                    return s;
                }else{
                    len--;
                }
            }
            return "";
        }else{
            String[] template=str2.split(str1);
            if(template.length==0){
                return str1;
            }
            int len=str1.length()/2;
            while(len>1){
                String s=str1.substring(0,len);
                if(str1.split(s).length==0&&str2.split(s).length==0){
                    return s;
                }else{
                    len--;
                }
            }
            return "";
        }
    }
}

package Atoi;

public class updateMyAtoi {
    public static void main(String[] args) {
        String str="3.1415";
        System.out.println(Conversion(str));
    }
    public static int Conversion(String str){
        if("".equals(str)){
            return 0;
        }
        int i=0,sign=1,length=str.length();
        double s=0;
        while(str.charAt(i)==' '&&i<length-1){
            i++;
        }
        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            sign=str.charAt(i++)=='-'?-1:1;
        }
        while(i<length&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            s=s*10+str.charAt(i++)-'0';
            if(s>Integer.MAX_VALUE){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return sign*(int)s;
    }
}

package Atoi;

public class myAtoi {
    public static void main(String[] args) {
        String str="3.14159";
        System.out.println(Conversion(str));
    }
    public static int Conversion(String str){
        if(str==null||str==""){
            return 0;
        }
        long num=0;
        int position=0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)==' '){
                continue;
            }
            if(str.charAt(i)>='0'&&str.charAt(i)<='9') {
                int a = (int) str.charAt(i);
                int tem = a - 48;
                long list = (long) (tem * Math.pow(10, position));
                num += list;
                position++;
            }else if(str.charAt(i)=='.'&&num!=0){
                num=0;
                position=0;
                continue;
            } else if((str.charAt(i)!='-'&&str.charAt(i)!='+')&&num!=0){
                return 0;
            }else if((str.charAt(i)!='-'&&str.charAt(i)!='+')&&num==0){
                continue;
            } else if((str.charAt(i)=='-'||str.charAt(i)!='+')&&num!=0){
                if(str.charAt(i)=='-'){
                    num=num*(-1);
                }
            }
        }
        int tem=(int)num;
        if(num>=0){
            return (tem==num)?tem:Integer.MAX_VALUE;
        }else
            return (tem==num)?tem:Integer.MIN_VALUE;
    }
}

package validNumber;

public class isNumber {
    public static void main(String[] args) {
        String s=" . ";
        System.out.println(isNumber(s));
    }

    private static void jumpblock(String s){
        //跳过空格
        while(s.charAt(index)==' ')
        {
            index++;
        }
    }
    //跳过数字序列，如果有数字序列返回true,否则返回false;
    private static boolean jumpdigits(String s){
        int j=index;
        while(index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
            index++;
        }
        return index>j?true:false;
    }
    //判断e之后序列是否符合要求
    private static boolean judgeAfterE(String s){
        if(index==s.length()){
            return false;
        }
        if(s.charAt(index)=='+'||s.charAt(index)=='-'){
            index++;
        }
        if(index==s.length()){
            return false;
        }
        boolean flag=jumpdigits(s);
        return index==s.length()&&flag;
    }
    private static boolean isNumber(String s){
        if(s.isEmpty()){
            return false;
        }
        jumpblock(s);
        if(s.charAt(index)=='+'||s.charAt(index)=='-'){
            index++;
        }
        if(index==s.length()){
            return false;
        }
        boolean flag=jumpdigits(s);
        if(index!=s.length()){
            if(s.charAt(index)==' '){
                jumpblock(s);
                if(index==s.length()){
                    return flag;
                }else{
                    return false;
                }
            }
            else if(s.charAt(index)=='.'){
                index++;
                boolean flag01=jumpdigits(s);
                if(s.charAt(index)==' '||index==s.length()){
                    jumpblock(s);
                    if(index==s.length()){
                        return flag||flag01;
                    }else{
                        return false;
                    }
                }else if((flag||flag01)&&s.charAt(index)=='e'){
                    ++index;
                    return judgeAfterE(s);
                }else
                    return false;
            }else if(flag&&s.charAt(index)=='e'){
                ++index;
                return judgeAfterE(s);
            }else
                return false;

        }else{
            return true;
        }
    }
    private static int index=0;
}

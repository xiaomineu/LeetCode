package longestCommonProfix;

public class longestProfix {
    public static void main(String[] args) {
        String[] strings={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
    }
    public static String longestCommonPrefix(String[] strs){
        if(strs==null||strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int minLength=strs[0].length();
        for(int i=0;i<strs.length;i++){
            minLength=Math.min(strs[i].length(),minLength);
        }
        int j=0;
        boolean flag=true;
        for(;j<minLength;j++){
            if(flag==true){
                char s=strs[0].charAt(j);
                for(int i=0;i<strs.length;i++){
                    if(s==strs[i].charAt(j)){
                        flag=true;
                    }else{
                        flag=false;
                        break;
                    }
                }
            }else{
                j--;
                break;
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        if(j>0){
           for(int i=0;i<j;i++){
               stringBuffer.append(strs[0].charAt(i));
           }
        }else {
            return "";
        }
        return stringBuffer.toString();
    }
}

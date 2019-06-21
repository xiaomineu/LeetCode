package ValidPalindrom;


public class isPalindrome {
    public static void main(String[] args) {
        String s="0P";
        System.out.println(isPaliname(s));
    }
    //判断是否是正确回文字符串
    //头尾指针同时遍历，指向字符相等，继续遍历
    private static boolean isPaliname(String s){
        if(s==null||s.length()==0){
            return true;
        }
        int first=0;
        int last=s.length()-1;
        s=s.toLowerCase();
        while(first<=last){
            char left=s.charAt(first);
            char right=s.charAt(last);
            if(((left>='a'&&left<='z')||(left>='0'&&left<='9'))&&((right>='a'&&right<='z')||(right>='0'&&right<='9'))){
                if(left==right){
                    first++;
                    last--;
                }else
                    return false;
            }else if((left>='a'&&left<='z')||(left>='0'&&left<='9')){
                last--;
            }else if((right>='a'&&right<='z')||(right>='0'&&right<='9')){
                first++;
            }else{
                last--;
                first++;
            }
        }
        return true;
    }
}

package PalindromeNumber;

public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x){
        //负数时，不是回文数
        if(x<0){
            return false;
        }
        //个位数时，是回文数
        if(x<10){
            return true;
        }
        int y=0;
        int tem=x;
        while(x!=0){
            y=y*10+x%10;
            x/=10;
        }
        return tem==y;
    }
}

package ReverseInteger;

public class ReverseInter {
    public static void main(String[] args) {
        System.out.println(Reverse(-210));
    }
    public static int Reverse(int x){
        long result=0;
        while(x!=0){
            result=result*10+x%10;
            x/=10;
        }
        int test=(int)result;
        return (test==result)?test:0;
    }
}

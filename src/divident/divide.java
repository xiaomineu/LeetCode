package divident;

public class divide {
    public static void main(String[] args) {
        System.out.println(dividetion(-2147483648,-1));
    }
    public static int dividetion(int dividend,int divisor){
        long result=(long)dividend/divisor;
        if(result>2147483647){
            return 2147483647;
        }else{
            return (int)result;
        }
    }
}

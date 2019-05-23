package Pow;

public class myPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.000000,
                4));
    }
    //保持与x相同的有效数字，采用位运算
    private static double myPow(double x,int n){
        if(n==0){
            return 1;
        }
        double result=myPow(x,n/2);

        if(n%2==0){
            return result*result;
        }else{
            return n>0?result*result*x:result*result*(1/x);//n==3时;
        }
//        long N=n;
//        if(N<0){
//            N=-N;
//            x=1/x;
//        }
//        double result=1;
//        for(long i=N;i>0;i=i/2){
//            if(i%2==1){
//                result*=x;
//            }
//            x*=x;
//        }
    }
}
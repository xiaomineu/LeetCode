package FactorialTrailingZeros;

public class trailingZeros {
    public static void main(String[] args) {

    }
    //阶乘中位数0的个数
    //位数为0主要取决于5倍数
    private static int trailing(int n){
        int count=0;
        while(n>0){
            n/=5;
            count+=n;
        }
        return count;
    }
}

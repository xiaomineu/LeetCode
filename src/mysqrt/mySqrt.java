package mysqrt;

public class mySqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
    }
    //二分查找法
    private static int sqrt(int x){
        if(x<=1){
            return x;
        }
        long left=0;
        long right=x/2;
        while(left<=right){
            long mid=(left+right)/2;
            if(mid*mid==x||(mid*mid<x&&(mid+1)*(mid+1)>x))
                return (int) mid;
            else if(mid*mid<x){
                left=mid+1;
            }else
                right=mid-1;
        }
        return 0;
    }
}

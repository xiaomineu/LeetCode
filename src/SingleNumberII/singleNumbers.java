package SingleNumberII;

public class singleNumbers {
    public static void main(String[] args) {
        int[] nums={1,1,1,2};
        System.out.println(num(nums));
    }
    //位运算，相当于状态转移电路，一个数出现3次，自动抵消；
    //使用2个二进制位

    /**0^x=x;
     * x^x=0;
     * x&~x=0;
     * x&~0=x;
     * 所以：
     * a=(a^x)&~b:当a==0,b==0时，
     * a=x;b=(b^x)&~a;b=0;第一次
     * a=(a^x)&~b;a=0;b=x;第二次
     * a=(a^x)&~b;a=0;b=0;第三次;
     * @param nums
     * @return
     */

    private static int num(int[] nums){
        int one=0;
        int two=0;
        for(int i:nums){
            one=one^i&~two;
            two=two^i&~one;
        }
        return one;
    }
}

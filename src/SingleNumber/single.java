package SingleNumber;

public class single {
    public static void main(String[] args) {

    }
    //使用异或进行运算;
    //a^b^a=a^a^b=b
    //0^a=a 0与任何数进行异或运算仍然是该数字
    //异或运算满足交换律;
    private int number(int[] nums){
        int a=0;
        for(int i:nums){
            a^=i;
        }
        return a;
    }
}

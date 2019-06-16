package SumofDigitsIntheMinimumNumber;

public class SumNumber {
    public static void main(String[] args) {
        int[] A={34,23,1,24,75,33,54,8};
        System.out.println(sumofDigits(A));
    }
    private static int sumofDigits(int[] A){
        int minNum=A[0];
        for(int i=1;i<A.length;i++){
            if(minNum>A[i]){
                minNum=A[i];
            }
        }
        int sum=0;
        if(minNum==100){
            return 0;
        }
        if(minNum>9){
            sum+=minNum/10;
            minNum=minNum/10;
        }
        sum+=minNum/1;
        return sum%2==0?1:0;
    }
}

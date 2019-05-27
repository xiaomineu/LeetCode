package PlusOne;

public class plusOne {
    public static void main(String[] args) {
        int [] digits={1,2,3};
        System.out.println(plus(digits));
    }
    private static int[] plus(int[] digits){
        int len=digits.length;
        int ele=1;
        for(int i=len-1;i>=0;i--){
            int template=(digits[i]+ele)/10;
            digits[i]=(digits[i]+ele)%10;
            ele=template;
        }
        if(ele==1){
            int [] list=new int[len+1];
            list[0]=ele;
            for(int i=1;i<list.length;i++){
                list[i]=digits[i-1];
            }
            return list;
        }else
            return digits;
    }
}

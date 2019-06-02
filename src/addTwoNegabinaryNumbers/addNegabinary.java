package addTwoNegabinaryNumbers;

public class addNegabinary {
    public static void main(String[] args) {
        int[] arr1={1};
        int[] arr2={1};
        System.out.println(add(arr1,arr2));
    }
    private static int[] add(int[] arr1,int[] arr2){
        int sample=0;
        for(int i=0;i<arr1.length;i++){
            if(i%2==1){
                arr1[i]=(-1)*arr1[i];
            }
        }
        for(int i=0;i<arr2.length;i++){
            if(i%2==1){
                arr2[i]=(-1)*arr2[i];
            }
        }
        int len=arr1.length>arr2.length?arr1.length:arr2.length;
        int i=arr1.length-1;
        int j=arr2.length-1;
        int[] nums=new int[len];
        while(i>=0||j>=0){
            if(i>-1&&j>-1){
                int num=sample+arr1[i--]+arr2[j--];
                if(num==-2){
                    sample=-1;
                }else if(num==2){
                    sample=1;
                }else
                    sample=0;
                num=(num<0)?(-1)*num:num;
                nums[--len]=num%2;
            }else if(i>-1){
                int num=sample+arr1[i--];
                if(num==-2){
                    sample=-1;
                }else if(num==2){
                    sample=1;
                }else
                    sample=0;
                num=(num<0)?(-1)*num:num;
                nums[--len]=num%2;
            }else{
                int num=sample+arr2[j--];
                if(num==-2){
                    sample=-1;
                }else if(num==2){
                    sample=1;
                }else
                    sample=0;
                num=(num<0)?(-1)*num:num;
                nums[--len]=num%2;
            }
        }
        if(sample!=0){
            int[] num=new int[nums.length+1];
            num[0]=1;
            for(int p=1;p<num.length;p++){
                num[p]=nums[p-1];
            }
            return num;
        }
        return nums;
    }
}

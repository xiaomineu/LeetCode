package PermutationSequence;


public class getPermutation {
    public static void main(String[] args) {
        System.out.println(getString(3,3));
    }


    private static String getString(int n,int k){
        if(n==1){
            return "1";
        }
        boolean[] flag=new boolean[n];
        int [] map=new int[n];
        map[1]=1;
        map[0]=1;
        for(int i=2;i<n;i++){
            map[i]=i*map[i-1];
        }
        k=k-1;
        char[] result=new char[n];
        int pos=0;
        while(pos<n){
            int base=map[n-pos-1];
            int skip=k/base;
            k=k%base;
            for(int i=0;i<n;i++){
                //首先判断当前数字是否已经被占用,若被占用，不能使用;
                if(!flag[i]){
                    //该数字未被使用，判断是否达到skip值
                    if(skip==0){
                        flag[i]=true;
                        result[pos++]=(char)(i+49);
                        break;
                    }else{
                        skip--;
                    }
                }
            }
        }
        return new String(result);
    }
}

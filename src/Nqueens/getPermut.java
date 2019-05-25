package Nqueens;

public class getPermut {
    public static void main(String[] args) {

    }
    private static String getString(int n,int k){
        if(n==1){
            return "1";
        }
        boolean [] flag=new boolean[n];
        char [] template={'1','2','3','4','5','6','7','8','9'};
        int [] map=new int[n];
        map[0]=1;
        map[1]=1;
        for(int i=2;i<map.length;i++){
            map[i]*=map[i-1];
        }
        k-=1;
        char [] result=new char[n];
        int pos=0;
        while(pos<n){
            int base=map[n-pos-1];
            int skip=k/base;
            k%=base;
            for(int i=0;i<n;i++){
                if(!flag[i]){
                    if(skip==0){
                        flag[i]=true;
                        result[pos++]=template[i];
                    }else{
                        skip--;
                    }
                }
            }
        }
        return new String(result);
    }
}

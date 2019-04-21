package Contest133;

import java.util.Arrays;

public class Num01 {
    public static void main(String[] args) {

    }
    public static int[][] allCellDistOrder(int R,int C,int r0,int c0){
        int [][]list=new int [R*C][2];
        int []num=new int[R*C];
        int r=r0;
        int c=c0;
        int position=0;
        Dist(R,C,r,c,position,num,r0,c0);
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            if(Math.abs(((r+c)-(r0+c0)))==num[i]){
                list[i][0]=r;
                list[i][1]=c;
            }
        }
        return list;
    }
    public static void Dist(int R,int C,int r,int c,int position,int [] num,int r0,int c0){
        if(IsBound(R,C,r,c)){
            num[position]=Math.abs(Math.abs(r-r0)+Math.abs(c-c0));
            Dist(R,C,r+1,c,position+1,num,r0,c0);
            Dist(R,C,r,c+1,position+1,num,r0,c0);
            Dist(R,C,r+1,c+1,position+1,num,r0,c0);
            Dist(R,C,r-1,c-1,position+1,num,r0,c0);
        }
        else
            return;
    }
    public static boolean IsBound(int R,int C,int r,int c){
        if(r==R||c==C){
            return false;
        }
        if(r<0||c<0){
            return false;
        }
        else
            return true;
    }
}

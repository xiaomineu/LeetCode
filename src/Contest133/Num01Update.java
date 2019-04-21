package Contest133;

import java.util.ArrayList;


public class Num01Update {
    public static void main(String[] args) {
        System.out.println(allCellDistOrder(2,3,0,0));
    }
    public static int[][] allCellDistOrder(int R,int C,int r0,int c0){
        ArrayList<int[]> arrayList=new ArrayList<>();
        int p=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                arrayList.add(new int[]{i,j,Math.abs(i-r0)+Math.abs(j-c0)});
            }
        }
        arrayList.sort((a,b)->(a[2]-b[2]));
        int [][] outPut=new int[R*C][2];
        for(int[] a:arrayList){
            outPut[p][0]=a[0];
            outPut[p][1]=a[1];
            p++;
        }
        return outPut;
    }
}

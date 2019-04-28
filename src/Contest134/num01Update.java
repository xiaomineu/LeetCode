package Contest134;

import java.util.Arrays;

public class num01Update {
    public static void main(String[] args) {

    }
    public static int[] movesCounts(int a,int b,int c){
        int [] list={a,b,c};
        Arrays.sort(list);
        int [] result=new int[2];
        int max=list[2]-list[0]-2;
        int min=2;
        if(list[2]-list[0]==2){
            min=0;
        }else{
            if(list[1]<=list[0]+2||list[2]<=list[1]+2)
            {
                min=1;
            }
        }
        result[0]=min;
        result[1]=max;
        return result;
    }
}

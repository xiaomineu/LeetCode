package Candy;

import java.util.Arrays;

public class candy {
    public static void main(String[] args) {
        int[] ratings={5,1,1,1,10,2,1,1,1,3};
        System.out.println(candyMain(ratings));
    }
    private static int candyMain(int[] ratings){
        int MinCandy=0;
        if(ratings==null||ratings.length==0){
            return MinCandy;
        }
        if(ratings.length==1){
            return 1;
        }
        int[] candy=new int[ratings.length];
        Arrays.fill(candy,1);
        int index=0;
        int minNumber=ratings[0];
        for(int i=0;i<ratings.length;i++){
            if(ratings[i]<minNumber){
                index=i;
                minNumber=ratings[i];
            }
        }
        for(int i=index-1;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=candy[i+1]+1;
            }else{
                int j=i;
                while(ratings[j]<ratings[j+1]){
                    candy[j+1]=Math.max(candy[j+1],candy[j]+1);
                    j+=1;
                }

            }
        }
        for(int i=index+1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }else{
                int j=i;
                while(ratings[j]<ratings[j-1]){
                    candy[j-1]=Math.max(candy[j]+1,candy[j-1]);
                    j-=1;
                }
            }
        }
        for(int i=0;i<candy.length;i++){
            MinCandy+=candy[i];
        }
        return MinCandy;
    }
}

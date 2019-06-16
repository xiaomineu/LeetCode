package HighFive;

public class highFiveScore {
    public static void main(String[] args) {
        int[][] items={{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        System.out.println(highFive(items));
    }
    private static int[][] highFive(int[][] items){
        int [][]count=new int[1001][6];
        for(int i=0;i<items.length;i++){
            int position=items[i][0];
             if(count[position][0]==0){
                 count[position][0]++;
                 count[position][1]=items[i][1];
             }else{
                 int length=count[position][0];
                 int score=items[i][1];
                 if(length>=5){
                     for(int j=1;j<=length;j++){
                         if(score>count[position][j]){
                             int tem=count[position][j];
                             count[position][j]=score;
                             score=tem;
                         }
                     }
                 }else{
                     count[position][0]++;
                     count[position][++length]=items[i][1];
                 }
             }
        }
        int numId=0;
        for(int i=1;i<count.length;i++){
            if(count[i][0]!=0){
                numId++;
            }
        }
        int[][] result=new int[numId][2];
        for(int i=1;i<count.length;i++){
            if(count[i][0]!=0){
                int sum=0;
                for(int j=1;j<=count[i][0];j++){
                    sum+=count[i][j];
                }
                result[i-1][0]=i;
                result[i-1][1]=sum/count[i][0];
            }
        }
        return result;
    }
}

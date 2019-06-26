package Candy;

import java.util.Arrays;

public class candy1 {
    public static void main(String[] args) {

    }
    //以左边为参照点，当当前节点大于左节点，糖数+1
    //以右边为参照点，相反方向遍历，当前节点大于右节点，判断右节点糖数+1与目前以左节点为参照的节点数大小情况，去最大值；
    private int candy(int[] ratings){
        int[] candy=new int[ratings.length];
        Arrays.fill(candy,1);
        for(int i=1;i<candy.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        int sum=candy[candy.length-1];
        for(int i=candy.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
            sum+=candy[i];
        }
        return sum;
    }
}

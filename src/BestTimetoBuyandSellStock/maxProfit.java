package BestTimetoBuyandSellStock;

public class maxProfit {
    public static void main(String[] args) {
        int[] prices={7,6,4,3,2,1};
        System.out.println(max(prices));
    }
    //买卖袜子获利
    //买的时间以及卖的时间
    private static int maxProfit(int[] prices){
        //最简单的暴力法
        int profit=0;
        int buyprice=0;
        int sellprice=0;
        for(int i=0;i<prices.length;i++){
            buyprice=prices[i];
            for(int j=i;j<prices.length;j++){
                sellprice=prices[j];
                profit=Math.max(profit,sellprice-buyprice);
            }
        }
        return profit;
    }
    private static int max(int[] prices){
        //one travel
        if(prices.length<=0){
            return 0;
        }
        int minPrice=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else{
                profit=Math.max(profit,prices[i]-minPrice);
            }
        }
        return profit;
    }
}

package BestTimetoBuyandSellStockII;

public class maxProfits {
    public static void main(String[] args) {

    }
    private static int maxProfit(int[] prices){
        int profit=0;
        int maxProfitSum=0;
        int minPrice=Integer.MAX_VALUE;
        //贪婪算法
        for(int i=0;i<prices.length;i++){
            //买入时机，存在比之前低的价格就买入
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            //判断当前是否有利润，有利润就卖出
            if(prices[i]-minPrice>profit){
                profit=prices[i]-minPrice;
                maxProfitSum+=profit;
                minPrice=prices[i];
                profit=0;
            }
        }
        return maxProfitSum;
    }
}

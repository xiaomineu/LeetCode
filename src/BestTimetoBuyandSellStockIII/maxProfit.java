package BestTimetoBuyandSellStockIII;

import java.util.Arrays;

public class maxProfit {
    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
        System.out.println(max(prices));
    }

    /**
     * 解法一：
     * 只进行两次抛售，获取最大值；
     * DP算法，将数组分成两列，作为两次抛售的;
     * 分别计算两次收益最大值
     * 时间复杂度O(n2),需要优化
     * @param prices
     * @return
     */
    private static int maxprofit(int []prices){
        int[] Maxprofit=new int[prices.length];
        if(prices==null||prices.length==0){
            return 0;
        }
        int i=0;
        while(i<prices.length){
            int minprice=Integer.MAX_VALUE;
            int profit=0;
            for(int j=0;j<=i;j++){
                if(prices[j]<minprice){
                    minprice=prices[j];
                }else{
                    profit=Math.max(profit,prices[j]-minprice);
                }
            }
            Maxprofit[i]+=profit;
            minprice=Integer.MAX_VALUE;
            profit=0;
            for(int j=i;j<prices.length;j++){
                if(prices[j]<minprice){
                    minprice=prices[j];
                }else{
                    profit=Math.max(profit,prices[j]-minprice);
                }
            }
            Maxprofit[i]+=profit;
            i++;
        }
        Arrays.sort(Maxprofit);
        return Maxprofit[i-1];
    }
    /**
     * 解法2：
     * 核心思路：
     * 假设手上有0元，买入股票价格为price,手中钱需要减去price,卖出股票价格为price,手上钱加上这个price
     * 四种状态：
     * Buy1[i]表示前i天做第一笔交易买入股票后剩下的最多的钱
     * Sell1[i]表示前i天做第一笔交易卖出股票后剩下的最多的钱
     * Buy2[i]表示前i天做第二笔交易买入后剩下的最多的钱
     * Sell2[i]表示前i天做第二笔交易卖出剩下的最多的钱
     * 状态转移方程;
     * Sell2[i]=max{Sell2[i-1],Buy2[i-1]+prices[i]}
     * Buy2[i]=max{Buy2[i-1],Sell1[i-1]-prices[i]}
     * Sell1[i]=max{Sell1[i-1],Buy1[i-1]+prices[1]}
     * Buy1[i]=max{Buy[i-1],-prices[i]};
     */
    private static int max(int[] prices){
        int buy1=Integer.MIN_VALUE;
        int buy2=Integer.MIN_VALUE;
        int sell1=0;
        int sell2=0;
        for(int i=0;i<prices.length;i++){
            sell2=Math.max(sell2,buy2+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy1=Math.max(buy1,-prices[i]);
        }
        return sell2;
    }
}

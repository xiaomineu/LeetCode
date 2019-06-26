package GasStation;

public class canCompleteCircuitII {
    public static void main(String[] args) {

    }
    public int canComplete(int[] gas,int[] cost){
        int res=0,curGap=0,totalGap=0;
        for(int i=0;i<gas.length;i++){
            curGap+=gas[i]-cost[i];
            if(curGap<0) res=(i+1>gas.length-1)?-1:i+1;
            curGap=Math.max(curGap,0);
            totalGap+=gas[i]-cost[i];
        }
        return totalGap<0?-1:res;
    }
}

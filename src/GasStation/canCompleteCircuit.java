package GasStation;

public class canCompleteCircuit {
    public static void main(String[] args) {
        int[] gas={2};
        int[] cost={2};
        System.out.println(canComplate(gas,cost));
    }

    private static int canComplate(int[] gas,int[] cost){
        for(int i=0;i<gas.length;i++){
            if(gas[i]>=cost[i]){
                int sum=gas[i];
                if(circle(gas,cost,i,sum)>=0){
                    return i;
                }
            }
        }
        return -1;
    }
    private static int circle(int[] gas,int[] cost,int start,int sum){
        int index=start;
        while(sum>=0){
            sum-=cost[start];
            if(sum<0){
                break;
            }
            if(start==gas.length-1){
                start=0;
            }else{
                start++;
            }
            if(start==index){
                return sum;
            }
            sum+=gas[start];
        }
        return -1;
    }
}

package Contest133;

import java.util.Arrays;

/**
 * 1.将所有人员全部先去往一个城市A，统计所有花费之和
 * 2.使用数组记录前往B城市与前往A城市之间的差价，必须是B-A;
 * 3.将数组排序
 * 4.将所有人员中的一半前往B城市，即将总花费加上从A前往B的花费
 * 若数组中值<0,表示直接前往b，退还前往A的费用;
 * 若>0，表示加价之间的费用
 */

public class Num02 {
    public int twoCitySchedCost(int [][]costs){
        int account=0;
        int [] list=new int[costs.length];
        for(int i=0;i<costs.length;i++){
            account+=costs[i][0];
            list[i]=costs[i][1]-costs[i][0];
        }
        Arrays.sort(list);
        for(int i=0;i<list.length/2;i++){
            account+=list[i];
        }
        return account;
    }
}

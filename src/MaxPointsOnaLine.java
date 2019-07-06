import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnaLine {
    public static void main(String[] args) {

    }
    //寻找一条线上最大的节点个数;
    private static int maxPoints(int[][] points){
        int res=0;
        for(int i=0;i<points.length;i++){
            int dup=0;
            int max=0;
            Map<String,Integer> map=new HashMap<>();
            for(int j=i+1;j< points.length;j++){
                int row=points[i][0]-points[j][0];
                int col=points[i][1]-points[j][1];
                //根据该点与其他点间斜率判断是否在同一线上;
                //points中可能含有重复点;
                if(row==0&&col==0){
                    dup++;
                    continue;
                }
                //辗转相除法，获得最大公约数;根据斜率统计点;
                int div=gcd(row,col);
                String key=(row/div)+","+(col/div);//根据最大公约数计算斜率;
                map.put(key,map.getOrDefault(key,0)+1);
                max=Math.max(max,map.get(key));
            }
            res=Math.max(res,max+dup+1);
        }
        return res;
    }
    //辗转相除计算横纵坐标最大公约数;
    private static int gcd(int row,int col){
        if(row==0)return col;
        return gcd(col%row,row);
    }
}

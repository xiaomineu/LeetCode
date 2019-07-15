package DungeonGame;

public class calcuateMinimumHP {
    public static void main(String[] args) {

    }
    //使用DP算法
    private static int calcult(int[][] dungeon){
        Integer[][] flag=new Integer[dungeon.length][dungeon[0].length];
        return 1+dfs(dungeon,0,0,flag);
    }
    public static int dfs(int[][] dungeon,int i,int j,Integer[][] flag){
        if(i<0||i>=flag.length||j<0||j>=flag[0].length){
            return Integer.MAX_VALUE;
        }
        //若该点不为null,表明已经被初始化过
        if(flag[i][j]!=null)return flag[i][j];
        //到达所在地时，HP设为0或负数绝对值;
        if(i==dungeon.length-1&&j==dungeon[0].length-1){
            return dungeon[i][j]>0?0:Math.abs(dungeon[i][j]);
        }
        //从目的地反推，到达此点时，最少剩余的HP;
        int res=dungeon[i][j]-Math.min(dfs(dungeon,i+1,j,flag),dfs(dungeon,i,j+1,flag));
        flag[i][j]=(res>0)?0:Math.abs(res);
        return flag[i][j];
    }
}

package Contest141;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShorestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,1},{1,0}};
        System.out.println(shorestPath(grid));
    }
    private static int shorestPath(int[][] grid){

        Queue<int[]> queue=new ArrayDeque<>();
        int n=grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1){
            return -1;
        }
        int[][] path=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(path[i],9999999);
        }
        path[0][0]=0;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] list=queue.poll();
            int row=list[0];
            int col=list[1];
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int rown=row+i;
                    int coln=col+j;
                    //判断该点的后继坐标是否越界以及是否曾经走过，避免重复
                    //path[rown][coln]>path[row][col]+1中不仅是避免重复，也是寻找最短路径
                    if(rown>=0&&rown<n&&coln>=0&&coln<n&&grid[rown][coln]==0&&path[rown][coln]>path[row][col]+1){
                        path[rown][coln]=path[row][col]+1;
                        queue.add(new int[]{rown,coln});
                    }
                }
            }
        }
        if(path[n-1][n-1]>99999)return -1;
        return path[n-1][n-1]+1;
    }

}

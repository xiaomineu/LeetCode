package MinimumPathSum;

public class minPathSum {
    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minSum(grid));
    }
    //贪心算法
    private static int minSum(int[][] grid){
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0||j==0){
                    if(i==0&&j==0){
                        continue;
                    }else{
                        grid[i][j]+=(i>0?grid[i-1][j]:grid[i][j-1]);
                    }
                }else{
                    grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[row-1][col-1];
    }
}

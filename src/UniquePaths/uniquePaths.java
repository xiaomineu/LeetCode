package UniquePaths;

public class uniquePaths {
    public static void main(String[] args) {
        System.out.println(unique(23,12));
    }
    //采用深搜
    private static int unique(int m,int n){
        boolean[][] flag=new boolean[m][n];
        int[] count=new int[1];
        route(m,n,0,0,flag,count);
        return count[0];
    }
    private static void route(int m,int n,int row,int col,boolean[][] flag,int[] count){
        if(row==m-1&&col==n-1){
            count[0]++;
            return;
        }
        if(row==m-1){
            if(!flag[row][col]){
                flag[row][col]=true;
                route(m,n,row,col+1,flag,count);
                flag[row][col]=false;
            }else{
                return;
            }
        }else if(col==n-1){
            if(!flag[row][col]){
                flag[row][col]=true;
                route(m,n,row+1,col,flag,count);
                flag[row][col]=false;
            }else{
                return;
            }
        }else{
            if(!flag[row][col]){
                flag[row][col]=true;
                route(m,n,row+1,col,flag,count);
                route(m,n,row,col+1,flag,count);
                flag[row][col]=false;
            }else{
                return;
            }
        }
    }
}

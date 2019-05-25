package spiralMatrixII;

public class generateMatrix {
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
    private static int[][] generate(int n){
        int[][] matrix=new int[n][n];
        Matrix(0,n-1,0,n-1,matrix,n);
        return matrix;
    }
    private static void Matrix(int left,int right, int top,int bottem,int[][] matrix,int n){
        int i=1;
        while(i<=n*n){
            for(int j=left;j<=right;j++){
                matrix[top][j]=i++;
            }
            top++;
            for(int j=top;j<=bottem;j++){
                matrix[j][right]=i++;
            }
            right--;
            for(int j=right;j>=left;j--){
                matrix[bottem][j]=i++;
            }
            bottem--;
            for(int j=bottem;j>=top;j--){
                matrix[j][left]=i++;
            }
            left++;
        }
    }
}

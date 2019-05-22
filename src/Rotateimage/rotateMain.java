package Rotateimage;

public class rotateMain {
    public static void main(String[] args) {

    }
    //模拟题
    //将矩阵旋转90度，直接改变原数组下标
    //寻找下标变换规律
    public void rotate(int[][] matrix){
        int matrixLength=matrix.length;
        for(int i=0;i<matrixLength/2;i++){
            for(int j=i;j<matrixLength-i-1;j++){
                int template=matrix[i][j];
                matrix[i][j]=matrix[matrixLength-j-1][i];
                matrix[matrixLength-j-1][i]=matrix[matrixLength-1-i][matrixLength-1-j];
                matrix[matrixLength-1-i][matrixLength-1-j]=matrix[j][matrixLength-1-i];
                matrix[j][matrixLength-1-i]=template;
            }
        }
    }
}

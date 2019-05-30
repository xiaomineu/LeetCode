package setMatrixZeros;

public class zero {
    public static void main(String[] args) {

    }

    /**
     * 使用矩阵中第一行以及第一列作为标记位
     * matrix[0][0]作为判断第一行，第一列置为0的标记
     * 如果矩阵中，遍历过程中，第一列不遍历，该数字为0，其所在下标对应的该行与该列的第一个元素置为0
     * 除去第一行第一列元素外，遍历数组
     * 每次判断该位置对应的第一行，第一列元素是否为0，如果为0，将该位置元素置为0
     * 对于第一行及第一列元素
     * 第一行：若第一行第一个元素为0，则第一行元素都置为0
     * flag表示第一列中是否含有0元素
     * 若flag==true;
     * 则该列元素全部置为0
     * @param matrix
     */
    private static void setZeros(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        boolean flag=false;
        for(int i=0;i<row;i++){
            if(matrix[i][0]==0){
                flag=true;
            }
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int i=0;i<col;i++){
                matrix[0][i]=0;
            }
        }
        if(flag){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
    }
}

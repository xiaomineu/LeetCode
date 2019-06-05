package FlipColumnsForMaximumNumberOfEqualRows;

import java.util.Arrays;

public class maxEqualRowsAfterFlips {
    public static void main(String[] args) {
        int[][] matrix={{1,0,0,0,1,1,1,0,1,1,1},{1,0,0,0,1,0,0,0,1,0,0},{1,0,0,0,1,1,1,0,1,1,1},{1,0,0,0,1,0,0,0,1,0,0},{1,1,1,0,1,1,1,0,1,1,1}};
        System.out.println(maxRows(matrix));
    }
    //uwi's method is referenced
    private static int maxRows(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        int len=0;
        for(int i=0;i<row;i++){
            int template=0;
            inner:
            for(int j=i;j<row;j++){
                //当两行数组相等时，需要可以认为其经过列变换后，全部相等
                if(Arrays.equals(matrix[i],matrix[j])){
                    template++;
                }else{
                    for(int k=0;k<col;k++){
                        //当两行数组不相等时，若其数字不是相对相反时，经过变换后，该行仍然无法全部相等;
                        if(matrix[i][k]+matrix[j][k]!=1)continue inner;
                    }
                    template++;
                }
            }
            len=Math.max(len,template);
        }
        return len;
    }
}

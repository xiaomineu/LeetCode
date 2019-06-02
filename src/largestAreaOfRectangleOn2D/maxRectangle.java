package largestAreaOfRectangleOn2D;

public class maxRectangle {
    public static void main(String[] args) {
        char[][] matrix={};
        System.out.println(maxArea(matrix));
    }
    private static int maxArea(char[][] matrix){
        max=0;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                if(matrix[row][col]=='1'){
                    max=Math.max(max,1);
                    area(matrix,row,col,1,1);
                }
            }
        }
        return max;
    }
    private static int max=0;
    private static void area(char[][] matrix,int row,int col,int w,int h){
        if(col+w<matrix[0].length){
            for(int k=0;k<h;k++){
                if(matrix[row+k][col+w]=='0'){
                    break;
                }
                if(k==h-1){
                    max=Math.max(max,h*(w+1));
                    area(matrix,row,col,w+1,h);
                }
            }
        }
        if(row+h<matrix.length){
            for(int k=0;k<w;k++){
                if(matrix[row+h][col+k]=='0'){
                    break;
                }
                if(k==w-1){
                    max=Math.max(max,(h+1)*w);
                    area(matrix,row,col,w,h+1);
                }
            }
        }
    }
}

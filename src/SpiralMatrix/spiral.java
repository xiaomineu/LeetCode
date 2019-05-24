package SpiralMatrix;


import java.util.ArrayList;
import java.util.List;

public class spiral {
    public static void main(String[] args) {
        int[][] matrix={{1},{2},{3}};
        System.out.println(spiralOrder(matrix));
    }
    private static List<Integer> spiralOrder(int[][] matrix){
        List<Integer>list=new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        Order(matrix,0,matrix[0].length-1,0,matrix.length-1,list);
        return list;
    }
    private static void Order(int[][] matrix,int left,int right,int top,int bottem,List<Integer> list){
        while(left<=right&&top<=bottem){
            if(left>right){
                break;
            }
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            if(top>bottem){
                break;
            }
            for(int j=top;j<=bottem;j++){
                list.add(matrix[j][right]);
            }
            right--;
            if(right<left){
                break;
            }
            for(int i=right;i>=left;i--){
                list.add((matrix[bottem][i]));
            }
            bottem--;
            if(bottem<top){
                break;
            }
            for(int j=bottem;j>=top;j--){
                list.add(matrix[j][left]);
            }
            left++;
        }
    }
}

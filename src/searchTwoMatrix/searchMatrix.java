package searchTwoMatrix;

public class searchMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1},{3}};
        System.out.println(search(matrix,3));
    }
    private static boolean search(int[][] matrix,int target){
        if(matrix.length==0){
            return false;
        }
        int col=matrix[0].length;
        int left=0;
        int right=col;
        int position=findPosition(matrix,target);
        while(left<right){
            int mid=(left+right)/2;
            if(matrix[position][mid]>target){
                right=mid;
            }else if(matrix[position][mid]<target){
                left=mid+1;
            }else
                return true;
        }
        return false;
    }
    private static int findPosition(int[][] matrix,int target){
        int left=0;
        int right=matrix.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(matrix[mid][0]>target){
                right=mid-1;
            }else if(matrix[mid][0]<target){
                if (mid == left) {
                    if(matrix[mid+1][0]<=target){
                        left++;
                    }
                    break;
                }
                left = mid;
            }else{
                return mid;
            }
        }
        return left;
    }
}

package WordSearch;

public class exist {
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(exist(board,word));
    }

    /**
     * 使用回溯法寻找路径
     * @param board
     * @param word
     * @return
     */
    private static boolean exist(char[][] board,String word){
        boolean[][] flag=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(findPath(board,flag,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean findPath(char[][] board,boolean[][] flag,String word,int row,int col,int index){
        if(index==word.length()){
            return true;
        }
        if(row<0||row>=board.length||col<0||col>=board[0].length){
            return false;
        }
        if(!flag[row][col]){
            if(board[row][col]==word.charAt(index)){
                flag[row][col]=true;
                if(findPath(board,flag,word,row+1,col,index+1)||findPath(board,flag,word,row-1,col,index+1)||
                        findPath(board,flag,word,row,col-1,index+1)||findPath(board,flag,word,row,col+1,index+1)){
                    return true;
                }else{
                    flag[row][col]=false;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}

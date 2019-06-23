package surroundedRegions;

public class solve {
    public static void main(String[] args) {
        char[][] board={{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        method(board);
    }
    //字符转换，连接到边界的‘O'不被转化，否则转换为'X'
    //遍历字符数组，边界数组不做判断;
    private static void method(char[][] board){
        if(board.length<=0){
            return;
        }
        int row=board.length;
        int col=board[0].length;
        //审题偏差，应该是只要区域中所有的有一个边界点是O,则该区域均保持不变;
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++){
//                if(i==0||i==row-1||j==0||j==col-1){
//                    continue;
//                }
//                if(board[i][j]=='X'){
//                    continue;
//                }else{
//                    if(i-1==0||i+1==row-1||j-1==0||j+1==col-1){
//                        if(i-1==0){
//                            if(board[i-1][j]=='O'){
//                                continue;
//                            }
//                        }else if(i+1==row-1){
//                            if(board[i+1][j]=='O'){
//                                continue;
//                            }
//                        }else if(j-1==0){
//                            if(board[i][j-1]=='O'){
//                                continue;
//                            }
//                        }else if(j+1==col-1){
//                            if(board[i][j+1]=='O'){
//                                continue;
//                            }
//                        }
//                        board[i][j]='X';
//                    }else
//                        board[i][j]='X';
//                }
//            }
//        }
        //使用DFS，遍历节点附近;
        //以边界为基础点进行深度优先遍历，若为‘O',则标记为't'
        //如果某个不与边界'O'相连的点为'O'，则保持'O'不变，最后转变为'X';
        for(int i=0;i<row;i++){
            dfs(i,0,board);
            dfs(i,col-1,board);
        }
        for(int i=0;i<col;i++){
            dfs(0,i,board);
            dfs(row-1,i,board);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='t'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    private static void dfs(int row,int col,char[][]board){
        if(row<0||col<0||row>=board.length||col>=board[0].length)return;
        if(board[row][col]=='X'||board[row][col]=='t')return;
        board[row][col]='t';
        dfs(row-1,col,board);
        dfs(row+1,col,board);
        dfs(row,col-1,board);
        dfs(row,col+1,board);
    }
}

package Nqueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//n皇后问题

public class queen {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }
    //使用回溯法
    private static List<List<String>> solve(int n){
        List<List<String>> list=new ArrayList<>();
        boolean[][] flag=new boolean[n][n];
        judge(list,flag,0,0,0);
        return list;
    }

    /**
     * @param list
     * @param flag
     * @param row
     * @param col
     * @param count 皇后个数
     */
    private static void judge(List<List<String>>list,boolean[][] flag,int row,int col,int count){
        if(count==flag.length){
            List<String> stringList=new LinkedList<>();
            for(int i=0;i<flag.length;i++){
                char[] template=new char[flag.length];
                for(int j=0;j<flag.length;j++){
                    if(flag[i][j]){
                        template[j]='Q';
                    }else{
                        template[j]='.';
                    }
                    if(j==flag.length-1){
                        stringList.add(String.copyValueOf(template));
                    }
                }
            }
            list.add(stringList);
            return;
        }

        for(int p=0;p<flag.length;p++){
            if(rowExist(row,p,flag)==false){
                continue;
            }
            flag[row][p]=true;
            judge(list,flag,row+1,p,count+1);
            flag[row][p]=false;
        }
    }
    private static boolean rowExist(int row,int col,boolean[][] flag){
        //判断此列有无queen
        for(int i=0;i<row;i++){
            if(flag[i][col]){
                return false;
            }
        }
        //判断此行有无queen
        for(int i=0;i<col;i++){
            if(flag[row][i]){
                return false;
            }
        }
        //判断此斜行是否有queen
        int r=row-1;
        int cleft=col-1;
        int cright=col+1;
        while(r>=0&&cleft>=0){
            if(flag[r][cleft]){
                return false;
            }
            r--;
            cleft--;
        }
        r=row-1;
        while(r>=0&&cright<flag.length){
            if(flag[r][cright]){
                return false;
            }
            r--;
            cright++;
        }
        return true;
    }
}

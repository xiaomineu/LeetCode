package ValidSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class isValidSudoku{
    public static void main(String[] args) {

    }

    /**
     * 暴力枚举
     * 矩阵只有9*9,不存在超时可能
     * @param borad
     * @return
     */
    public static boolean isValidSudo(char[][] borad){
        //判断行
        int row=borad.length;
        //判断列
        int col=borad[0].length;
        Map<Character,Set<Integer>> rowMap=new HashMap<>();
        Map<Character,Set<Integer>> colMap=new HashMap<>();
        Map<Character,Set<Integer>> boxMap=new HashMap<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char c=borad[i][j];
                if(c=='.'){
                    continue;
                }
                if(!rowMap.containsKey(c)){
                    rowMap.put(c,new HashSet<>());
                }
                if(!colMap.containsKey(c)){
                    colMap.put(c,new HashSet<>());
                }
                if(!boxMap.containsKey(c)){
                    boxMap.put(c,new HashSet<>());
                }
                if(!rowMap.get(c).add(i)) return false;
                if(!colMap.get(c).add(j)) return false;
                if(!boxMap.get(c).add((i/3)*3+j/3)) return false;
            }
        }
        return true;
    }
}

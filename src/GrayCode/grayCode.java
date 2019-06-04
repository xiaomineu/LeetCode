package GrayCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class grayCode {
    public static void main(String[] args) {
        System.out.println(gray(3));
    }
    //gray code is the code which just one position bite changes at one time;
    //find the rules
    //gray code 编码规则

    /**
     * i代表的编码与i-1表示的编码取异或运算
     * @param n
     * @return
     */
    private static List<Integer> gray(int n){
        List<Integer> list=new LinkedList<>();
        int len=(int)Math.pow(2,n);
        for(int i=0;i<len;i++){
            list.add(i^(i>>1));
        }
        return list;
    }
}

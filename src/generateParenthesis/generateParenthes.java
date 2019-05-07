package generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法
 * 统计左右括号个数
 * 设定边界条件：
 * 到达总括号个数：添加进容器中
 * 右括号大于左括号，插入右括号
 * 左括号个数小于要求，可继续插入，插入位置标记
 */
public class generateParenthes {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }
    public static List<String> generateParenthesis(int n){
        List<String> list=new ArrayList<>();
        subList(0,0,0,list,new char[2*n]);
        return list;
    }
    public static void subList(int left,int right,int position,List list,char[] chars){
        if(position==chars.length){
            list.add(new String(chars));
            return;
        }
        if(right<left&&position<chars.length){
            chars[position]=')';
            subList(left,right+1,position+1,list,chars);
        }
        if(left<chars.length/2){
            chars[position]='(';
            subList(left+1,right,position+1,list,chars);
        }
    }
}

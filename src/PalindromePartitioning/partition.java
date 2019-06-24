package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class partition {
    public static void main(String[] args) {

    }
    //判断是否是回文字符串;
    //using DFS to solve the problem is extremely useful on problems like permutation combination
    private static List<List<String>> partitionList(String s){
        List<List<String>> result=new ArrayList<>();
        if(s==null||s.length()==0){
            return result;
        }
        List<String> template=new ArrayList<>();
        boolean[][] flag=generate(s);
        dfs(result,template,0,s,flag);
        return result;
    }
    //method to judge the partition
    /*
    private static boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
    */
    //using dynamic method to memory the position from i--j is palindrome;
    private static boolean[][] generate(String s){
        boolean[][] map=new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                map[i][j]=(s.charAt(i)==s.charAt(j)&&(j-i<=2||map[i+1][j-1]));
            }
        }
        return map;
    }
    private static void dfs(List<List<String>> result,List<String> template,int start,String s,boolean[][] flag){
        if(start==s.length()){
            result.add(new ArrayList<>(template));
        }
        for(int i=start;i<s.length();i++){
            if(flag[start][i]){
                template.add(s.substring(start,i+1));
                dfs(result,template,i+1,s,flag);
                template.remove(template.size()-1);
            }
        }
    }
}

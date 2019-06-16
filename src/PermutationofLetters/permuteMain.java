package PermutationofLetters;

public class permuteMain {
    public static void main(String[] args) {
        String s="{a,b}c{d,e}f";
        permute(s);
    }
    private static String[] permute(String s){
        if(s==null){
            return null;
        }
        String[] first=s.split("}");

        boolean[] flag=new boolean[first.length];
        for(int i=0;i<first.length;i++){
            for(int j=0;j<first[i].length();j++){
                if(first[i].charAt(j)=='{'){
                    flag[i]=true;
                }
            }
        }
        //使用递归,将string数组分开;

        return null;
    }
}

package PalindromePartitioningII;

public class minCut {
    public static void main(String[] args) {
        String s="aaaamnnbb";
        System.out.println(minCutNum(s));
    }
    private static int minCutNum(String s){
        int len=s.length();
        if(s==null||s.length()<=1){
            return 0;
        }
        //using O(n2) to marked the i--j is the palindrome subString
        boolean[][] flag=new boolean[len][len];
        int[] nums=new int[len];
        flagMarked(flag,s,nums);
        //using nums signed the minimum cut times of subString;
        //nums[i] means the during the 0--i the minimum cut times
        return nums[len-1];
    }
    private static void flagMarked(boolean[][] flag,String s,int[] nums){
        for(int i=0;i<s.length();i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<=i;j++){
                flag[j][i]=s.charAt(i)==s.charAt(j)&&(i-j<=2||flag[j+1][i-1]);
                if(flag[j][i]){
                    //the subString of j--i is palindrome,so the minimum cut times is the nums[j]+1;
                    min=j==0?0:Math.min(min,nums[j-1]+1);
                }
            }
            nums[i]=min;
        }
    }
}

package maxSumTwoNoIver;

/**
 * 数组中L个连续数与M个连续数最大之和
 * 贪心算法：
 *      对于前n项和，每次都取n中当前M项或N项和最大
 */
public class maxSumTwoNoOverlap {
    public static void main(String[] args) {
        int[] A={3,8,1,3,2,1,8,9,0};
        int L=3,M=2;
        System.out.println(maxSumTwoNoOver(A,L,M));
    }
    public static int maxSumTwoNoOver(int A[],int L,int M){
        //建立辅助数组记录原始数组前n项和
        int[] sum=new int[A.length+1];
        for(int i=1;i<sum.length;i++){
            sum[i]=A[i-1]+sum[i-1];
        }
        int ref=Integer.MIN_VALUE/2;
        {
            int max=Integer.MIN_VALUE/2;
            for(int i=0;i<sum.length;i++){
                if(i>L+M){
                    max=Math.max(max,sum[i-L]-sum[i-L-M]);
                    ref=Math.max(ref,max+sum[i]-sum[i-L]);
                }
            }
        }
        {
            int max=Integer.MIN_VALUE/2;
            for(int i=0;i<sum.length;i++){
                if(i>L+M){
                    max=Math.max(max,sum[i-M]-sum[i-M-L]);
                    ref=Math.max(ref,max+sum[i]-sum[i-M]);
                }
            }
        }
        return ref;
    }
}

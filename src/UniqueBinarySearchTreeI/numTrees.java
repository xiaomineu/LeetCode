package UniqueBinarySearchTreeI;

public class numTrees {
    public static void main(String[] args) {
        System.out.println(numTree(4));
    }
    //找规律

    /**
     * DP算法：
     * 第n个节点插入前n-1个节点构成的树
     * @param n
     * @return
     * d[4]=d[0]*d[3]+d[1]*d[2]+d[2]*d[1]+d[3]*d[0];
     */
    private static int numTree(int n){
        int[] d=new int[n+1];
        //当n=0时,null树对应
        d[0]=1;
        for(int i=1;i<d.length;i++){
            for(int j=0;j<i;j++){
                d[i]+=d[j]*d[i-j-1];
            }
        }
        return d[n];
    }
}

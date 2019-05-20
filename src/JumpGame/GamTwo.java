package JumpGame;

public class GamTwo {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 每次都是从路径最小点跳至此节点
     * @param nums
     * @return
     */
    private static int jump(int[] nums){
        int[] count=new int[nums.length];
        count[0]=0;
        for(int i=0;i<nums.length;i++){
            int length=nums[i];
            for(int j=i+1;j<=j+length;j++){
                if(count[i]==0){
                    count[j]=count[i]+1;
                }else{
                    count[j]=Math.min(count[i]+1,count[j]);
                }
            }
        }
        return count[nums.length-1];
    }
}

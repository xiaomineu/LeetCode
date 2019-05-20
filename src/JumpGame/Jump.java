package JumpGame;

public class Jump {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(jump(nums));
    }
    private static int jump(int[] nums){
        if(nums.length<2){
            return 0;
        }
        //MaxReach表示可以下次可以移动到的点
        int start=0;
        int steps=0;
        int Reach=0;
        int maxRange=0;
        while(true){
            int i;
            for(i=start+1;i<=start+nums[start];i++){
                if(i==nums.length-1){
                    return ++steps;
                }
                if(maxRange<i+nums[i]){
                    maxRange=i+nums[i];
                    Reach=i;
                }
            }
            start=Reach;
            steps++;
            if(maxRange>nums.length-1){
                return ++steps;
            }
        }
    }
}

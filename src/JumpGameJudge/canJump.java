package JumpGameJudge;

public class canJump {
    public static void main(String[] args) {
        int[] nums={2,0,0};
        System.out.println(Judge(nums));
    }
    private static boolean Judge(int[] nums){
        int maxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(i<=maxIndex){
                maxIndex= Math.max(nums[i]+i,maxIndex);
            }
        }
        if(maxIndex>=nums.length-1){
            return true;
        }
        return false;
    }
}

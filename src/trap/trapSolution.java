package trap;

public class trapSolution {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    //当遍历至数组中某一节点时，若要计算此节点中存储水容量，需要知道此节点中左右墙高度
    //水容量计算公式为：water=Math.min(left[i],right[i])-height[i]
    public static int trap(int[] height){
        int [] left=new int[height.length];
        int [] right=new int[height.length];
        int leftHeight=0;
        int rightHeight=0;
        for(int i=0;i<left.length;i++){
            if(height[i]>leftHeight){
                leftHeight=height[i];
            }
            left[i]=leftHeight;
        }
        for(int i=right.length-1;i>-1;i--){
            if(height[i]>rightHeight){
                rightHeight=height[i];
            }
            right[i]=rightHeight;
        }
        int water=0;
        for(int i=0;i<height.length;i++){
            water+=Math.min(left[i],right[i])-height[i];
        }
        return water;
    }
}

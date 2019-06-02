package largestRectangleArea;

public class largestRectangle {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestArea(heights));
    }
    //467ms, faster than 8.61%
    //40.5mb,less than 60.32%
    private static int largestArea(int[] heights){
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int height=heights[i];
            int area=0;
            for(int j=i;j<heights.length;j++){
                height=Math.min(height,heights[j]);
                area=height*(j-i+1);
                maxArea=Math.max(area,maxArea);
            }
        }
        return maxArea;
    }
}

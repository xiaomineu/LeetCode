package largestRectangleArea;
//faster method
public class solution02 {
    public static void main(String[] args) {

    }
    private static int largestAreaOfRectangle(int[] heights){
        int max=0;
        for(int i=0;i<heights.length;i++){
            int minHeight=heights[i];
            for(int curr=i;curr>=0;curr--){
                minHeight=Math.min(minHeight,heights[curr]);
                max=Math.max(max,minHeight*(i-curr+1));
            }
        }
        return max;
    }
}

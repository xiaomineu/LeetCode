package HeightChecker;

import java.util.Arrays;

public class heightChecker {
    public static void main(String[] args) {
        int [] heights={1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
    private static int heightChecker(int [] heights){
        int[] height=heights.clone();
        Arrays.sort(heights);
        int count=0;
        for(int i=0;i<height.length;i++){
            if(height[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }
}

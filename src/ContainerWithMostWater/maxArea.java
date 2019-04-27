package ContainerWithMostWater;

/**
 * 最大面积计算
 * 1.贪心算法，每次都求解当前最大面积
 * 2.头尾指针，底为指针之差，高为当前指针最小高度
 * 3.每次移动指针中较矮的，保留较高的墙（贪心）
 */


public class maxArea {
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(Area(height));
    }
    public static int Area(int [] height){
        if(height==null||height.length<2){
            return 0;
        }
        int MaxArea=0;
        int right=height.length-1;
        int left=0;
        while(left<right){
            int bottem=right-left;
            int high=(height[left]>height[right])?height[right]:height[left];
            int Area=bottem*high;
            MaxArea=Math.max(MaxArea,Area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return MaxArea;
    }
}

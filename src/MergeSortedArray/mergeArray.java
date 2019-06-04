package MergeSortedArray;

public class mergeArray {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
    }
    private static void merge(int [] nums1,int m,int[] nums2,int n){
        m=m-1;
        n=n-1;
        for(int i=nums1.length-1;i>=0;i--){
            if(m>-1&&n>-1&&nums1[m]>nums2[n]){
                nums1[i]=nums1[m--];
            }else if(m>-1&&n>-1&&nums1[m]<=nums2[n]){
                nums1[i]=nums2[n--];
            }else if(m<0){
                nums1[i]=nums2[n--];
            }else{
                nums1[i]=nums1[m--];
            }
        }
    }
}

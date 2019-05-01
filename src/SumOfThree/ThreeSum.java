package SumOfThree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums={0,4,-1,0,3,1,1,0,-3,2,-5,-4,-3,0,0,-3};
        System.out.println(sum(nums));
    }
    public  static List<List<Integer>> sum(int[] nums){
        Arrays.sort(nums);
    /**
     * 1.创建一个链表，存储选中节点
     * 2.将数组排序，
     * 3.设立前后两个指针，作为遍历节点
     * 4.设立游标，从前指针向后指针依次遍历，如果满足题意，则存储三指针指向数值
     * 5.如果之和小于0，游标指针向后移动
     * 6.如果之和大于0，后指针向前移动
     */
    List<List<Integer>> list= new LinkedList();
        for(int i=0;i<nums.length-2;i++){
        int j = nums.length - 1;
        int rear = i + 1;
        while (i < j&&rear<j) {
            if (nums[i] + nums[j] + nums[rear] == 0) {
                list.add(Arrays.asList(nums[i], nums[rear], nums[j]));
                //排除重复节点
                while (i < j && nums[i] == nums[i + 1]){
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) j--;
                j--;
                rear++;
            } else if (nums[i] + nums[j] + nums[rear] < 0) {
                rear++;
            } else {
                j--;
            }
        }
    }
        return list;
}
}

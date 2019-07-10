package TwoSumII_InputArrayIsSorted;

import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] numbers={2,7,11,15};
        System.out.println(twoPosition(numbers,9));
    }
    private static int[] two(int[] numbers,int target){
        int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(numbers[0],1);
        for(int i=1;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                result[0]=map.get(target-numbers[i])>i+1?i+1:map.get(target-numbers[i]);
                result[1]=map.get(target-numbers[i])<i+1?i+1:map.get(target-numbers[i]);
            }else
                map.put(numbers[i],i+1);
        }
        return result;
    }
    private static int[] twoPosition(int[] numbers,int target){
        int[] result=new int[2];
        //有序链表，使用头尾指针依次判断;
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]>target){
                right--;
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }else{
                result[0]=left+1;
                result[1]=right+1;
                break;
            }
        }
        return result;
    }

}

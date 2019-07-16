package LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {
    public static void main(String[] args) {
        int[] nums={999999998,999999997,999999999};
        System.out.println(largest(nums));
    }
    private static String largest(int[] nums){
        //贪心算法
        //超时
        StringBuffer stringBuffer=new StringBuffer(String.valueOf(nums[0]));
        for(int i=1;i<nums.length;i++){
            StringBuffer tem=new StringBuffer(stringBuffer);
            StringBuffer s=new StringBuffer(String.valueOf(nums[i]));
            tem=tem.append(s);
            s=s.append(stringBuffer);
            if(Integer.valueOf(s.toString())>=Integer.valueOf(tem.toString())){
                stringBuffer=s;
            }else{
                stringBuffer=tem;
            }
        }
        return stringBuffer.toString();
    }
    private class LargerNumber implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String order=o1+o2;
            String order2=o2+o1;
            return order2.compareTo(order);
        }
    }
    public String largestNum(int[] nums) {
        String[] list = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            list[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(list,new LargerNumber());
        if(list[0].equals("0")){
            return "0";
        }
        String largestNumber=new String();
        for(String s:list){
            largestNumber+=s;
        }
        return largestNumber;
    }
}

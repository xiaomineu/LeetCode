package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination {
    public static void main(String[] args) {
        int[] candidates={10,7,1,2,1,6,5};
        System.out.println(combinationSum(candidates,8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> result=new ArrayList<>();
        if(candidates.length<=0||target<=0){
            return result;
        }
        Arrays.sort(candidates);
        List curr=new ArrayList<>();
        DFS(result,curr,target,0,0,candidates);
        return result;
    }

    /**
     * 可以重复利用一个数字，所以每次都代入同一个数字，直到它达到target或者它超过target,此时回退一个数字，继续寻找下一个数字
     * 每次迭代中，当前数字也要重复迭代
     * @param result
     * @param curr
     * @param target
     * @param position
     * @param sum
     * @param candidates
     */
    private static void DFS(List<List<Integer>> result,List curr,int target,int position,int sum,int[] candidates){
        if(sum>target) return;
        if(sum==target){
            result.add(new ArrayList<>(curr));
            //返回并且跳出迭代，因为后续数字必将大于target
            return;
        }else{
            for(int i=position;i<candidates.length;i++){
                curr.add(candidates[i]);
                DFS(result,curr,target,i,sum+candidates[i],candidates);
                //删除上一次中添加元素
                curr.remove(curr.size()-1);
            }
        }
    }
}

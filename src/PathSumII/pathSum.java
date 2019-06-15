package PathSumII;


import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class pathSum {
    public static void main(String[] args) {
        TreeNode root=null;
        System.out.println(psth(root,1));
    }
    private static List<List<Integer>> psth(TreeNode root,int sum){

        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        List<Integer> template=new ArrayList<>();
        pathList(list,template,root,sum);
        return list;
    }
    private static void pathList(List<List<Integer>>list,List<Integer> template,TreeNode root,int sum){
            template.add(root.val);
            int subSum=sum-root.val;
            if(subSum==0&&root.left==null&&root.right==null){
                list.add(new ArrayList<>(template));
                template.remove(template.size()-1);
                return;
            }
            if(root.left!=null){
               pathList(list,template,root.left,subSum);
            }
            if(root.right!=null){
                pathList(list,template,root.right,subSum);
            }
            template.remove(template.size()-1);
    }
}

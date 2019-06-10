package UniqueBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;


public class generateTrees {
    public static void main(String[] args) {

    }
    //BST树，采用回溯法，根节点数值必须大于左孩子，小于右孩子
    private List<TreeNode> general(int n){
        boolean[] flag=new boolean[n+1];
        List<TreeNode> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            flag[i]=true;
            TreeNode root=new TreeNode(i);
            TreeNodes(flag,root,0,i,n);
            flag[i]=false;
            list.add(root);
        }
        return list;
    }
    private static void TreeNodes(boolean[] flag,TreeNode node,int left,int index,int right){
        if(left==index||index==right){
            return;
        }
        else{
            for(int i=left;i<index;i++){
                if(!flag[i]){
                    flag[i]=true;
                    node.left=new TreeNode(i);
                    TreeNodes(flag,node,left,i,right);
                    flag[i]=false;
                }else{
                    node.left=null;
                }
            }
            for(int j=index+1;j<right;j++){
                if(!flag[j]){
                    flag[j]=true;
                    node.right=new TreeNode(j);
                    TreeNodes(flag,node,j,j,right);
                    flag[j]=false;
                }else{
                    node.right=null;
                }
            }
        }
    }
}

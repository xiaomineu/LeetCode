package ConstructBinaryTreeFromPreorderAndInorderTraversal;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class buildTree {
    public static void main(String[] args) {

    }

    /**
     * 根据中序遍历以及先序遍历构建二叉树
     * 先序遍历确定根节点
     * 中序遍历确定左右子树的节点个数
     * 所有结点均有先序遍历确定
     * 在中序遍历中确定节点个数
     * 所以，在中序遍历中确定偏移量（表示子树节点个数）
     *
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode buildTree(int[] preorder,int[] inorder){
        return TreeBuild(preorder,inorder,0,preorder.length-1,0);
    }
    private static TreeNode TreeBuild(int[] preorder,int[] inorder,int start,int end,int offset){
        //递归基
        if(preorder==null||start>end){
            return null;
        }
        TreeNode root=new TreeNode(preorder[start+offset]);
        //左子树中节点个数(划定边界)
        int index=getIndex(preorder[start+offset],inorder);
        //左子树根节点为前序遍历父节点的下一个节点
        root.left=TreeBuild(preorder,inorder,start,index-1,offset+1);
        //右节点为前序遍历中根据中序遍历中确定左子树节点个数后的下一个节点
        root.right=TreeBuild(preorder,inorder,index+1,end,offset);
        return root;
    }
    private static int getIndex(int value,int[] inorder){
        if(inorder==null||inorder.length==0){
            return -1;
        }
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==value){
                return i;
            }
        }
        return -1;
    }
}

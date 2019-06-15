package FlattenBinaryTreeToLinkedList;
public class flatten {
    public static void main(String[] args) {

    }
    private TreeNode preNode=null;
    private void flattenNode(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        //断开父节点与右节点的联系，插入左节点
        if(preNode!=null){
            preNode.left=null;
            preNode.right=root;
        }
        preNode=root;
        flattenNode(left);
        flattenNode(right);
    }
}

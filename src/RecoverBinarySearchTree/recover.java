package RecoverBinarySearchTree;
class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(int x){
        val=x;
    }
}

public class recover {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        new recover().recoverTree(root);
    }

    /**
     * using O(n)space is pretty straight forward
     * in-mid traversal on BST could reveal the misplace elements
     * key point:
     *      which elements are misplaced when you do in-order traversal ,you only have min element with and no max
     *      so the minest elements should be marked to compared
     * Only the minest TreeNode need to be swapped
     * 只有两个节点被交换
     * 所以只需要找到第一次出现异常的节点以及最后一次出现异常的节点
     * 交换两个节点
     * @param root
     */
    TreeNode val1=null;
    TreeNode val2=null;
    TreeNode min=null;
    public void recoverTree(TreeNode root){
        traversal(root);
        int template=val1.val;
        val1.val=val2.val;
        val2.val=template;
    }
    private void traversal(TreeNode root){
        if(root==null)return;
        traversal(root.left);
        if(min!=null&&root.val<min.val){//比较中序遍历中当前节点与前一节点数值是否有序，无序表示异常
            if(val1==null){
                val1=min;//第一次出现异常的节点
                val2=root;
            }else{
                val2=root;//最后一次出现异常的节点
            }
        }
        min=root;
        traversal(root.right);
    }
}

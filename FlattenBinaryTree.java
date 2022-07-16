public class FlattenBinaryTree {
    public void flattenToList(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (cur.left != null) {
                prev = cur.left;

                while (prev.right != null)
                    prev = prev.right;

                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}

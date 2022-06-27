import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class IsBST {
    public boolean isValidBST(TreeNode root) {
        return IsBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE, new HashSet<>());
    }

    private boolean IsBSTUtil(TreeNode root, int minValue, int maxValue, Set<Integer> vals) {
        if (root == null)
            return true;

        if (!vals.contains(root.val))
            vals.add(root.val);
        else
            return false;

        return (root.val <= maxValue && root.val >= minValue && IsBSTUtil(root.left, minValue, root.val, vals)
                && IsBSTUtil(root.right, root.val, maxValue, vals));
    }
}

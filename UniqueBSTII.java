import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this(val, null, null);
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class UniqueBSTII {

    // Using Divide and conquer strategy
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();

        return util(1, n);
    }

    private List<TreeNode> util(int m, int n) {
        List<TreeNode> res = new ArrayList<>();
        if (m > n) {
            res.add(null);
            return res;
        }

        for (int i = m; i <= n; i++) { // i is chosen as the root
            List<TreeNode> leftSubtree = util(m, i - 1);
            List<TreeNode> rightSubtree = util(i + 1, n);
            for (TreeNode l : leftSubtree) {
                for (TreeNode r : rightSubtree) {
                    TreeNode cur = new TreeNode(i, l, r);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueBSTII treeBuilder = new UniqueBSTII();
        System.out.println(treeBuilder.generateTrees(3)); // Will build 5 structurally unique BSTs
    }
}

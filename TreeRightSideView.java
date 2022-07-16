import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode rightNode = null;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    rightNode = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if (rightNode != null)
                res.add(rightNode.val);
        }
        return res;
    }

    public List<Integer> leftSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        leftViewUtil(root, res, 0);
        return res;
    }

    private void leftViewUtil(TreeNode root, List<Integer> res, int depth) {
        if (root == null)
            return;

        if (res.size() == depth)
            res.add(root.val);

        leftViewUtil(root.left, res, depth + 1);
        leftViewUtil(root.right, res, depth + 1);
    }
}

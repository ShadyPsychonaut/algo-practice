import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++)
            inorderMap.put(inorder[i], i);

        return buildTreeUtil(preorder, inorderMap, 0, preorder.length - 1);
    }

    private TreeNode buildTreeUtil(int[] preorder, Map<Integer, Integer> inorderMap, int left, int right) {
        if (left > right)
            return null;

        int value = preorder[preorderIndex++];
        TreeNode root = new TreeNode(value);

        root.left = buildTreeUtil(preorder, inorderMap, left, inorderMap.get(value) - 1);
        root.right = buildTreeUtil(preorder, inorderMap, inorderMap.get(value) + 1, right);

        return root;
    }
}

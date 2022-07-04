import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    // Using Binary search (piles of cards), O(n * log n)
    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>();
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0)
                pile = ~pile; // pile = 0 - pile - 1;
            if (pile == piles.size())
                piles.add(num);
            else
                piles.set(pile, num);
        }
        return piles.size();
    }

    // Using DP, O(n ^ 2)
    public int lengthOfLISUsingDP(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;

        int ans = 0;
        int[] memo = new int[n];
        memo[0] = 1;

        for (int i = n - 1; i >= 1; i--) {
            if (ans >= i + 1)
                break;
            ans = Math.max(ans, dpUtil(nums, i, memo));
        }

        return ans;
    }

    private int dpUtil(int[] nums, int i, int[] memo) {
        if (memo[i] != 0)
            return memo[i];
        // if (i == 0)
        // return 1;

        int len = 0;

        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i])
                len = Math.max(len, dpUtil(nums, j, memo));
        }

        memo[i] = 1 + len;
        return memo[i];
    }

    // Function to return the LIS
    public List<Integer> printLIS(int[] nums) {
        List<Node> piles = new ArrayList<>();
        for (int num : nums) {
            Node node = new Node(num);
            int pile = Collections.binarySearch(piles, node);
            if (pile < 0)
                pile = ~pile;

            if (pile != 0)
                node.prev = piles.get(pile - 1);

            if (pile == piles.size())
                piles.add(node);
            else
                piles.set(pile, node);
        }
        return extractLIS(piles);
    }

    private List<Integer> extractLIS(List<Node> piles) {
        List<Integer> res = new ArrayList<>();
        for (Node cur = piles.isEmpty() ? null : piles.get(piles.size() - 1); cur != null; cur = cur.prev) {
            res.add(cur.val);
        }
        Collections.reverse(res);
        return res;
    }

    private static class Node implements Comparable<Node> {
        int val;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Node that) {
            return Integer.compare(this.val, that.val);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18, 20, 12, 23 };
        LongestIncreasingSubsequence solver = new LongestIncreasingSubsequence();
        System.out.println(solver.lengthOfLISUsingDP(nums)); // prints 6
        System.out.println(solver.lengthOfLIS(nums)); // prints 6
        System.out.println(solver.printLIS(nums)); // prints [2, 3, 7, 18, 20, 23]
    }

}

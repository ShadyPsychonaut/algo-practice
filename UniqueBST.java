public class UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int numNodesOnLeft = j - 1;
                int numNodesOnRight = i - j;
                dp[i] += 2 * (dp[numNodesOnLeft] * dp[numNodesOnRight]);
            }
            if (i % 2 != 0)
                dp[i] += dp[i / 2] * dp[i / 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBST solver = new UniqueBST();
        System.out.println(solver.numTrees(6)); // outputs 132
    }
}

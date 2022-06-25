import java.util.HashMap;
import java.util.Map;

class UniquePaths {
    public int uniquePaths(int m, int n, Map<String, Integer> memo) {
        String key = (m <= n) ? "" + m + "," + n : "" + n + "," + m;

        if (memo.containsKey(key))
            return memo.get(key);
        if (m == 1 || n == 1)
            return 1;

        memo.put(key, uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo));

        return memo.get(key);
    }

    public static void main(String[] args) {
        UniquePaths solver = new UniquePaths();
        System.out.println(solver.uniquePaths(18, 8, new HashMap<>()));
    }
}

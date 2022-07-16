import java.util.Scanner;

public class LargestGardenSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = 0; j < n; j++) {
                if (j >= a && j <= b) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = 0;
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == 1) {
                    int val = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    val = Math.min(val, dp[i - 1][j - 1]);
                    if (val >= 1)
                        dp[i][j] = val + 1;
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println("\n" + ans);
        sc.close();
    }
}

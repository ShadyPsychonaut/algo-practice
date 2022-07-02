public class KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (count(matrix, mid) >= k) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }

    private int count(int[][] matrix, int num) {
        int row = matrix.length - 1;
        int col = 0;
        int counter = 0;
        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] > num)
                row--;
            else {
                counter += row + 1;
                col++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        KthSmallestElement solver = new KthSmallestElement();
        System.out.println(solver.kthSmallest(matrix, 8)); // prints 13
    }
}

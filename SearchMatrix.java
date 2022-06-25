public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        int C = matrix[0].length;

        int i = 0, j = C - 1;
        while (i < R && j >= 0) {
            if (target == matrix[i][j])
                return true;
            else if (target > matrix[i][j])
                i++;
            else
                j--;
        }

        return false;
    }
}

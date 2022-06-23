class RotateImage {
    public void rotateFourCells(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        System.out.println();
        reflect(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        print(matrix);

    }

    private void reflect(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, j, i, j, n - 1 - i);
            }
        }

        print(matrix);
    }

    public void rotate2(int[][] matrix) {
        transposeRightDiagonal(matrix);
        System.out.println();
        reflectHorizontal(matrix);
    }

    private void transposeRightDiagonal(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, n - 1 - j, j, n - 1 - i);
            }
        }
        print(matrix);
    }

    private void reflectHorizontal(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
        print(matrix);
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    private void print(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m1 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        // Input 2D array
        // 5 1 9 11
        // 2 4 8 10
        // 13 3 6 7
        // 15 14 12 16

        RotateImage r = new RotateImage();

        r.print(m1);
        System.out.println();

        r.rotate(m1);
        System.out.println();
        // Rotated 2D array
        // 15 13 2 5
        // 14 3 4 1
        // 12 6 8 9
        // 16 7 10 11

        int[][] m2 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        r.rotate2(m2);
    }
}
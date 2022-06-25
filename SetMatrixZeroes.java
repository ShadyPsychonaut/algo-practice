import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<int[]> indices = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    indices.add(new int[] { i, j });
            }
        }
        for (int[] index : indices) {
            // sets the complete row to 0
            for (int i = 0; i < matrix[0].length; i++)
                matrix[index[0]][i] = 0;

            // sets the complete column to 0
            for (int i = 0; i < matrix.length; i++)
                matrix[i][index[1]] = 0;
        }
    }
}

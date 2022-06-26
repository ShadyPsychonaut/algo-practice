public class WordSearch {
    boolean wordExists = false;

    public boolean exist(char[][] board, String word) {

        int R = board.length;
        int C = board[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (wordExists)
                        return true;
                    backtrack(board, word, i, j, 0, R, C, dirs);
                }
            }
        }

        return wordExists;
    }

    private void backtrack(char[][] board, String word, int row, int col, int pos, int R, int C, int[][] dirs) {
        if (pos == word.length()) {
            wordExists = true;
            return;
        }
        if (row < 0 || col < 0 || row == R || col == C)
            return;
        if (board[row][col] != word.charAt(pos))
            return;

        char c = board[row][col];
        board[row][col] = '*'; // To mark visited cell

        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            backtrack(board, word, newRow, newCol, pos + 1, R, C, dirs);
            if (wordExists)
                return;
        }

        board[row][col] = c;

    }

    public static void main(String[] args) {
        char[][] grid = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        WordSearch search = new WordSearch();
        System.out.println(search.exist(grid, "ABCCEES")); // outputs true

        WordSearch s = new WordSearch();
        System.out.println(s.exist(grid, "ABCCFB")); // outputs false
    }
}

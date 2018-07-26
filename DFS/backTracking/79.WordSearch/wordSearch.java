class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0
            || board[0].length == 0 || word == null
            || word.length() == 0) {
            return false;
        }
        int m =  board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]
                    && dfs(board, i, j, m, n, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j,
                        int m, int n, String word, int index) {
        char c = board[i][j];
        board[i][j] = '#';
        if (index == word.length() - 1) {
            return true;
        }
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n
                || board[x][y] == '#'
                || board[x][y] != word.charAt(index + 1)) {
                continue;
            }
            if (dfs(board, x, y, m, n, word, index + 1)) {
                board[i][j] = c;
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}
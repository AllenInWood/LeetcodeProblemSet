class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0, m, n);
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1, m, n);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j, m, n);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O') {
                bfs(board, m - 1, j, m, n);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'U') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    private void bfs(char[][] board, int i, int j, int m, int n) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(i, j));
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            board[p.first][p.second] = 'U';
            for (int[] dir : dirs) {
                int x = p.first + dir[0];
                int y = p.second + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
                    continue;
                }
                stack.push(new Pair(x, y));
            }
        }

    }
}
class Pair {
    public int first;
    public int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
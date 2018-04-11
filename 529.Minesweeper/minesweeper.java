class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {//Mine
            board[row][col] = 'X';
        } else {//Empty
            int count = 0;
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                if (board[x][y] == 'M' || board[x][y] == 'X') {
                    count++;
                }
            }
            if (count > 0) {// surround by mine
                board[row][col] = (char) (count + '0');
            } else {//no mine around, do DFS
                board[row][col] = 'B';
                for (int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (board[x][y] == 'E') {
                        updateBoard(board, new int[] {x, y});
                    }
                }
            }
        }
        return board;
    }
}
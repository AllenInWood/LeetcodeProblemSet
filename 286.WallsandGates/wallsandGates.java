class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0
            || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, m, n, 0);
                }
            }
        }
        return;
    }
    private void dfs(int[][] rooms, int i, int j, int m, int n, int deep) {
        rooms[i][j] = deep;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n
                || rooms[x][y] == -1 || rooms[x][y] < deep + 1) {
                continue;
            }
            dfs(rooms, x, y, m, n, deep + 1);
        }
    }
}
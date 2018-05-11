class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int max = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        for (int level = grid[0][0]; level <= max; level++) {
            if (dfs(grid, level, 0, 0, m, n, new boolean[m][n])) {
                return level;
            }
        }
        return -1;
    }
    private boolean dfs(int[][] grid, int level, int i, int j, int m, int n, boolean[][] visited) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] > level) {
                continue;
            }
            if (dfs(grid, level, x, y, m, n, visited)) {
                return true;
            }
        }
        return false;
    }
}
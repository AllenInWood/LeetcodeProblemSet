class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        boolean hasZero = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    boolean[][] visited = new boolean[m][n];
                    max = Math.max(max, dfs(grid, i, j, m, n, visited));
                    if (max == m * n) {
                        return max;
                    }
                    grid[i][j] = 0;
                    hasZero = true;
                }
            }
        }
        return hasZero ? max : m * n;
    }
    private int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        visited[i][j] = true;
        int result = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == 0) {
                continue;
            }
            result += dfs(grid, x, y, m, n, visited);
        }
        return result;
    }
}
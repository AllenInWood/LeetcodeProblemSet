class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0
            || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Set<List<List<Integer>>> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<List<Integer>> temp = new ArrayList<>();
                    dfs(i, j, i, j, grid, m, n, temp);
                    islands.add(temp);
                }
            }
        }
        return islands.size();
    }
    private void dfs(int i0, int j0, int i, int j, int[][] grid,
                     int m, int n, List<List<Integer>> temp) {
        temp.add(Arrays.asList(i - i0, j - j0));
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
                continue;
            }
            dfs(i0, j0, x, y, grid, m, n, temp);
        }
    }
}
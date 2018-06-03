class Solution {
    // DFS
    
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0
            || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int numOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0
                || y >= n || grid[x][y] == '0') {
                continue;
            }
            dfs(grid, x, y, m, n);
        }
    }
    
    
    // BFS : Time Limit Exceeded
    // int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // public int numIslands(char[][] grid) {
    //     if (grid == null || grid.length == 0
    //         || grid[0].length == 0) {
    //         return 0;
    //     }
    //     int m = grid.length, n = grid[0].length;
    //     int numOfIslands = 0;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (grid[i][j] == '1') {
    //                 bfs(grid, i, j, m, n);
    //                 numOfIslands++;
    //             }
    //         }
    //     }
    //     return numOfIslands;
    // }
    // private void bfs(char[][] grid, int i, int j, int m, int n) {
    //     List<int[]> list = new ArrayList<>();
    //     list.add(new int[]{i, j});
    //     while (list.size() != 0) {
    //         for (int index = 0; index < list.size(); index++) {
    //             int[] cur = list.get(index);
    //             grid[cur[0]][cur[1]] = '0';
    //             for (int[] dir : dirs) {
    //                 int x = cur[0] + dir[0];
    //                 int y = cur[1] + dir[1];
    //                 if (x < 0 || x >= m || y < 0
    //                     || y >= n || grid[x][y] == '0') {
    //                     continue;
    //                 }
    //                 list.add(new int[]{x, y});
    //             }
    //         }
    //     }
    // }
}
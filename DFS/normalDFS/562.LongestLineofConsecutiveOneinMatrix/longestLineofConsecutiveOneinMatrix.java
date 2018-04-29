class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int res = 0;
        int m = M.length, n = M[0].length;
        for (int[] dir : dirs) {
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (M[i][j] == 1 && !visited[i][j]) {
                        res = Math.max(res, dfs(M, i, j, m, n, dir, visited));
                    }
                }
            }
        }
        return res;
    }
    private int dfs(int[][] M, int i, int j, int m, int n,
                     int[] dir, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || M[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(M, i + dir[0], j + dir[1], m, n, dir, visited);
    }
}
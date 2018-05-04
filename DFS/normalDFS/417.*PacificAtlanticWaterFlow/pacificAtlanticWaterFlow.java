class Solution {
    // dfs
//     int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//     public List<int[]> pacificAtlantic(int[][] matrix) {
//         List<int[]> ans = new ArrayList<>();
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//             return ans;
//         }
//         int m = matrix.length, n = matrix[0].length;
//         boolean[][] pacific = new boolean[m][n];
//         boolean[][] atlantic = new boolean[m][n];
//         for (int i = 0; i < m; i++) {
//             dfs(matrix, i, 0, m, n, pacific);
//             dfs(matrix, i, n - 1, m, n, atlantic);
//         }
//         for (int j = 0; j < n; j++) {
//             dfs(matrix, 0, j, m, n, pacific);
//             dfs(matrix, m - 1, j, m, n, atlantic);
//         }
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (pacific[i][j] && atlantic[i][j]) {
//                     ans.add(new int[]{i, j});
//                 }
//             }
//         }
//         return ans;
//     }
    
//     private void dfs(int[][] matrix, int i, int j, int m, int n, boolean[][] visited) {
//         visited[i][j] = true;
//         for (int[] dir : dirs) {
//             int x = i + dir[0];
//             int y = j + dir[1];
//             if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] < matrix[i][j] || visited[x][y]) {
//                 continue;
//             }
//             dfs(matrix, x, y, m, n, visited);
//         }
//     }
    
    
    
    // bfs
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
            aQueue.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pQueue.offer(new int[]{0, j});
            pacific[0][j] = true;
            aQueue.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }
        
        // pacific
        while (!pQueue.isEmpty()) {
            int[] cur = pQueue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n
                    || matrix[x][y] < matrix[cur[0]][cur[1]] || pacific[x][y]) {
                    continue;
                }
                pacific[x][y] = true;
                pQueue.offer(new int[]{x, y});
            }
        }
        
        // atlantic
        while (!aQueue.isEmpty()) {
            int[] cur = aQueue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n
                    || matrix[x][y] < matrix[cur[0]][cur[1]] || atlantic[x][y]) {
                    continue;
                }
                atlantic[x][y] = true;
                aQueue.offer(new int[]{x, y});
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
}
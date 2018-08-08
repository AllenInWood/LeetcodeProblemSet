class Solution {
    // Union find
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0
            || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols
                            && grid[x][y] == '1') {
                            int pre = i * cols + j;
                            int cur = x * cols + y;
                            uf.union(cur, pre);
                        }
                    }
                }
            }
        }
        return uf.count;
    }
    
    class UnionFind {
        private int m, n;
        private int[] father;
        private int count = 0;
        public UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            father = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        father[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }
        
        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 != find2) {
                father[find2] = find1;
                count--;
            }
        }
        
        public int find(int node) {
            if (father[node] == node) {
                return node;
            }
            father[node] = find(father[node]);
            return father[node];
        }
    }
    
    // DFS
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
    //                 dfs(grid, i, j, m, n);
    //                 numOfIslands++;
    //             }
    //         }
    //     }
    //     return numOfIslands;
    // }
    // private void dfs(char[][] grid, int i, int j, int m, int n) {
    //     grid[i][j] = '0';
    //     for (int[] dir : dirs) {
    //         int x = i + dir[0];
    //         int y = j + dir[1];
    //         if (x < 0 || x >= m || y < 0
    //             || y >= n || grid[x][y] == '0') {
    //             continue;
    //         }
    //         dfs(grid, x, y, m, n);
    //     }
    // }
    
    
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
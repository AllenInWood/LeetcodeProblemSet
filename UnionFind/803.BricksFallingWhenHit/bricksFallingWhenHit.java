class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            }
        }
        for (int i = 0 ; i < m; i++)  {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    unionAround(i, j, grid, uf);
                }
            }
        }
        int count = uf.count[uf.find(m * n)];
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int[] hit = hits[i];
            if (grid[hit[0]][hit[1]] == 2) {
                unionAround(hit[0], hit[1], grid, uf);
                grid[hit[0]][hit[1]] = 1;
            }
            int newCount = uf.count[uf.find(m * n)];
            res[i] = (newCount - count > 0) ? newCount - count - 1 : 0;
            count = newCount;
        }
        return res;
    }
    
    private void unionAround(int i, int j, int[][] grid, UnionFind uf) {
        int m = grid.length;
        int n = grid[0].length;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                uf.union(i * n + j, x * n + y);
            }
        }
        if (i == 0) {
            uf.union(i * n + j, m * n);
        }
    }
    
    class UnionFind {
        int[] parents;
        int[] count;
        public UnionFind(int num) {
            parents = new int[num];
            count = new int[num];
            for (int i = 0; i < num; i++) {
                parents[i] = i;
                count[i] = 1;
            }
        }
        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 == find2) {
                return;
            }
            parents[find2] = find1;
            count[find1] += count[find2];
        }
        public int find(int node) {
            while (node != parents[node]) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }
    }
}
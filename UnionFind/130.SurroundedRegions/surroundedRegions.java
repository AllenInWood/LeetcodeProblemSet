class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0
            || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        int dummyNode = m * n;
        UnionFind uf = new UnionFind(dummyNode + 1);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        uf.union(i * n + j, dummyNode);
                    } else {
                        for (int[] dir : dirs) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y <= n
                                && board[x][y] == 'O') {
                                int pre = i * n + j;
                                int cur = x * n + y;
                                uf.union(pre, cur);
                            }
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (uf.find(i * n + j) == uf.find(dummyNode)) {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    
    class UnionFind {
        int[] father;
        int[] rank;
        public UnionFind(int num) {
            father = new int[num];
            rank = new int[num];
            for (int i = 0; i < num; i++) {
                father[i] = i;
            }
        }
        
        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (rank[find1] < rank[find2]) {
                father[find1] = find2;
            } else {
                father[find2] = find1;
                if (rank[find1] == rank[find2]) {
                    rank[find1]++;
                }
            }
        }
        
        public int find(int node) {
            while (node != father[node]) {
                father[node] = father[father[node]];
                node = father[node];
            }
            return node;
        }
    }
}
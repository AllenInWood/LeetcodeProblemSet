class Solution {
    int rows, cols;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] matrix;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if (positions == null || positions.length == 0
            || positions[0].length == 0) {
            return ans;
        }
        rows = m;
        cols = n;
        matrix = new int[m][n];
        UnionFind uf = new UnionFind(rows * cols);
        
        for (int[] position : positions) {
            uf.addNode(position[0], position[1]);
            ans.add(uf.count());
        }
        return ans;
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int num) {
            parent = new int[num];
            rank = new int[num];
            count = 0;
        }
        
        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 == find2) {
                return;
            }
            if (rank[find1] < rank[find2]) {
                parent[find1] = find2;
            } else {
                parent[find2] = find1;
                if (rank[find1] == rank[find2]) {
                    rank[find1]++;
                }
            }
            count--;
        }
        
        public int find(int node) {
            while (node != parent[node]) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        
        public int count() {
            return count;
        }
        
        public void addNode(int i, int j) {
            matrix[i][j] = 1;
            int cur = i * cols + j;
            parent[cur] = cur;
            count++;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols
                    && matrix[x][y] == 1) {
                    int pre = x * cols + y;
                    union(cur, pre);
                }
            }
        }
    }
}
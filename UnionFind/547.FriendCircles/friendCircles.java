class Solution {
    int n;
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0
            || M[0].length == 0) {
            return 0;
        }
        n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int num) {
            count = num;
            parent = new int[num];
            rank = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
            }
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
    }
}
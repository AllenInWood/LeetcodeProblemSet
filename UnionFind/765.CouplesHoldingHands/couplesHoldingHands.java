class Solution {
    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0) {
            return 0;
        }
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int a = row[2 * i];
            int b = row[2 * i + 1];
            uf.union(a / 2, b / 2);
        }
        return n - uf.count;
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int num) {
            parent = new int[num];
            rank = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
            }
            count = num;
        }
        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 == find2) {
                return;
            }
            if (rank[find2] > rank[find1]) {
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
    }
}
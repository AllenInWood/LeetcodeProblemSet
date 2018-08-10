class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[]{-1, -1};
        }
        int num = 0;
        for (int[] edge : edges) {
            num = Math.max(num, edge[1]);
        }
        System.out.println(num);
        UnionFind uf = new UnionFind(num);
        for (int[] edge : edges) {
            if (uf.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        return new int[]{-1, -1};
    }
    
    class UnionFind {
        int[] parents;
        int[] rank;
        public UnionFind(int num) {
            parents = new int[num];
            rank = new int[num];
            for (int i = 0; i < num; i++) {
                parents[i] = i;
            }
        }
        public boolean union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 == find2) {
                return true;
            }
            if (rank[find1] < rank[find2]) {
                parents[find1] = find2;
            } else {
                parents[find2] = find1;
                if (rank[find1] == rank[find2]) {
                    rank[find1]++;
                }
            }
            return false;
            
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
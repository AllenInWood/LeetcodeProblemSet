class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, map, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        visited.add(i);
        for (int j : map.get(i)) {
            if (!visited.contains(j)) {
                dfs(j, map, visited);
            }
        }
    }
}
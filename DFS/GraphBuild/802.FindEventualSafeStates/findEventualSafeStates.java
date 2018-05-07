class Solution {
    // TLE
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         List<Integer> ans = new ArrayList<>();
//         if (graph == null || graph.length == 0) {
//             return ans;
//         }
//         Map<Integer, Set<Integer>> graphMap = new HashMap<>();
//         int len = graph.length;
//         for (int i = 0; i < len; i++) {
//             if (!graphMap.containsKey(i)) {
//                 graphMap.put(i, new HashSet<>());
//             }
//             for (int edge : graph[i]) {
//                 graphMap.get(i).add(edge);
//             }
//         }
        
//         for (int i = 0; i < len; i++) {
//             Set<Integer> visited = new HashSet<>();
//             if (dfs(graphMap, visited, i)) {
//                 ans.add(i);
//             }
//         }
//         return ans;
//     }
    
//     private boolean dfs(Map<Integer, Set<Integer>> graphMap, Set<Integer> visited, int start) {
//         if (visited.contains(start)) {
//             return false;
//         }
//         visited.add(start);
//         for (int edge : graphMap.get(start)) {
//             if (!dfs(graphMap, visited, edge)) {
//                 return false;
//             }
//         }
//         visited.(start);
//         return true;
//     }
    
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return ans;
        }
        Map<Integer, Set<Integer>> graphMap = new HashMap<>();
        int len = graph.length;
        for (int i = 0; i < len; i++) {
            if (!graphMap.containsKey(i)) {
                graphMap.put(i, new HashSet<>());
            }
            for (int edge : graph[i]) {
                graphMap.get(i).add(edge);
            }
        }
        
        int[] color = new int[len];
        for (int i = 0; i < len; i++) {
            if (dfs(graphMap, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }
    
    private boolean dfs(Map<Integer, Set<Integer>> graphMap, int[] color, int start) {
        if (color[start] != 0) {
            return color[start] == 1;
        }
        color[start] = 2;
        for (int edge : graphMap.get(start)) {
            if (!dfs(graphMap, color, edge)) {
                return false;
            }
        }
        color[start] = 1;
        return true;
    }
}
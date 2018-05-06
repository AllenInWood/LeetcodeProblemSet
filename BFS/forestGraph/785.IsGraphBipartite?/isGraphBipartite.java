class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        Queue<int[]> queue = new LinkedList<>();
        
        Set<Integer> curSet = new HashSet<>();
        Set<Integer> nextSet = new HashSet<>();
        int m = graph.length;
        for (int i = 0; i < m; i++) {
            if (!curSet.contains(i) && !nextSet.contains(i)) {
                if (!bfs(queue, curSet, nextSet, graph, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean bfs(Queue<int[]> queue, Set<Integer> curSet,
                        Set<Integer> nextSet, int[][] graph, int index) {
        queue.offer(graph[index]);
        curSet.add(index);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int node : cur) {
                    if (!nextSet.contains(node)) {
                        if (curSet.contains(node)) {
                            return false;
                        }
                       queue.offer(graph[node]);
                        nextSet.add(node); 
                    }
                }
            }
            Set<Integer> temp = curSet;
            curSet = nextSet;
            nextSet = temp;
        }
        return true;
    }


    // public boolean isBipartite(int[][] graph) {
    //     if (graph == null || graph.length == 0) {
    //         return false;
    //     }
    //     Set<Integer> curSet = new HashSet<>();
    //     Set<Integer> nextSet = new HashSet<>();
        
    //     for (int i = 0; i < graph.length; i++) {
    //         if (!curSet.contains(i) && !nextSet.contains(i)) {
    //             if (!dfs(graph, i, curSet, nextSet)) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    
    // private boolean dfs(int[][] graph, int i, Set<Integer> curSet, Set<Integer> nextSet) {
    //     curSet.add(i);
    //     for (int node : graph[i]) {
    //         if (!nextSet.contains(node)) {
    //             if (curSet.contains(node)) {
    //                 return false;
    //             }
    //             if (!dfs(graph, node, nextSet, curSet)) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
}
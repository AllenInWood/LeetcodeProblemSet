class Solution {
    // dfs, stackoverflow
    // int min;
    // public int integerReplacement(int n) {
    //     min = Integer.MAX_VALUE;
    //     dfs(n, 0);
    //     return min;
    // }
    // private void dfs(int n, int steps) {
    //     if (n == 1) {
    //         min = Math.min(min, steps);
    //         return;
    //     }
    //     if (n % 2 == 0) {
    //         dfs(n / 2, steps + 1);
    //     } else {
    //         dfs(n + 1, steps + 1);
    //         dfs(n - 1, steps + 1);
    //     }
    // }
    
    
    // bfs
    public int integerReplacement(int n) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer((long) n);
        Set<Long> visited = new HashSet<>();
        visited.add((long) n);
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                long cur = queue.poll();
                if (cur == 1) {
                    return step;
                }
                
                if (cur % 2 == 0) {
                    if (!visited.contains(cur >> 1)) {
                        queue.offer(cur >> 1);
                        visited.add(cur >> 1);
                    }
                } else {
                    if (!visited.contains(cur + 1)) {
                        queue.offer(cur + 1);
                        visited.add(cur + 1);
                    } 
                    if (!visited.contains(cur - 1)) {
                        queue.offer(cur - 1);
                        visited.add(cur - 1);
                    }
                }
            }
            step++;
        }
        return step;
    }
}
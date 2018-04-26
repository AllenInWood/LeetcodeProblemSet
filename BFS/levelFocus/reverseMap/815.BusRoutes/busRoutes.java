class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0
            || routes[0].length == 0) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        
        if (S == T) {
            return 0;
        }
        
       for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                List<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }
        
        queue.offer(S);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while (size-- > 0) {
                int cur = queue.poll();
                List<Integer> busLine = map.get(cur);
                for (int line : busLine) {
                    if (visited.contains(line)) {
                        continue;
                    }
                    visited.add(line);
                    for (int i = 0; i < routes[line].length; i++) {
                        if (routes[line][i] == T) {
                            return res;
                        }
                        queue.offer(routes[line][i]);
                    }
                }
            }
        }
        return -1;
    }
}
class Solution {
    class Node {
        String stop;
        double result;
        public Node(String stop, double result) {
            this.stop = stop;
            this.result = result;
        }
    }
    
    class Pair {
        String des;
        double value;
        public Pair(String des, double value) {
            this.des = des;
            this.value = value;
        }
    }
    
    Map<String, List<Pair>> map;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        if (equations == null || equations.length == 0) {
            return res;
        }
        map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new ArrayList<>());
            }
            map.get(equations[i][0]).add(new Pair(equations[i][1], values[i]));
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new ArrayList<>());
            }
            map.get(equations[i][1]).add(new Pair(equations[i][0], 1 / values[i]));
        }
        
        for (int i = 0; i < queries.length; i++) {
            if (!map.containsKey(queries[i][0])) {
                res[i] = -1.0;
                continue;
            }
            res[i] = bfs(queries[i]);
        }
        return res;
    }
    private double bfs(String[] query) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Node(query[0], 1.0));
        visited.add(query[0]);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.stop.equals(query[1])) {
                return cur.result;
            }
            if (map.containsKey(cur.stop)) {
                for (Pair next : map.get(cur.stop)) {
                    if (!visited.contains(next.des)) {
                        queue.offer(new Node(next.des, cur.result * next.value));
                        visited.add(next.des);
                    }
                }
            }
        }
        return -1.0;
    }
}
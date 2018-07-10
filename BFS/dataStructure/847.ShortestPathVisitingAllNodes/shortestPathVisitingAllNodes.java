class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<Tuple> queue = new LinkedList<>();
        Set<Tuple> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            int tmp = (1 << i);
            set.add(new Tuple(tmp, i, 1));
            queue.offer(new Tuple(tmp, i, 1));
        }
        
        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
            
            if (curr.bitMask == (1 << N) - 1) {
                return curr.cost - 1;
            } else {
                int[] neighbors = graph[curr.cur];
                for (int neighbor : neighbors) {
                    int bitMask = curr.bitMask;
                    bitMask = bitMask | (1 << neighbor);
                    Tuple next = new Tuple(bitMask, neighbor, curr.cost + 1);
                    if (!set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
class Tuple {
    int bitMask;
    int cur;
    int cost;
    
    public Tuple(int bitMask, int cur, int cost) {
        this.bitMask = bitMask;
        this.cur = cur;
        this.cost = cost;
    }
    
    @Override
    public boolean equals(Object o) {
        Tuple t = (Tuple) o;
        return bitMask == t.bitMask
            && cur == t.cur && cost == t.cost;
    }
    
    @Override
    public int hashCode() {
        return 1331 * bitMask + 7193 * cur + 727 * cost;
    }
}
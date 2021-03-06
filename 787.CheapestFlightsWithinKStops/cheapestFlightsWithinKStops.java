class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) {
                prices.put(f[0], new HashMap<>());
            }
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, src, K + 1});// new int[] {price, desc, leftFlight}
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int price = top[0];
            int city = top[1];
            int flight = top[2];
            if (city == dst) {
                return price;
            }
            if (flight > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, flight - 1});
                }
            }
        }
        return -1;
    }
}
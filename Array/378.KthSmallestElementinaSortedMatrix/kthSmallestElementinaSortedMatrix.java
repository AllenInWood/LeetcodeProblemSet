class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0
            || matrix[0].length == 0) {
            return -1;
        }
        int n = matrix.length;
        PriorityQueue<List<Integer>> pq =
            new PriorityQueue<>((a, b) -> (a.get(0) - b.get(0)));
        for (int i = 0; i < n; i++) {
            pq.offer(Arrays.asList(matrix[0][i], 0, i));
        }
        for (int j = 0; j < k - 1; j++) {
            List<Integer> list = pq.poll();
            if (list.get(1) == n - 1) {
                continue;
            }
            pq.offer(Arrays.asList(matrix[list.get(1) + 1][list.get(2)],
                                   list.get(1) + 1, list.get(2)));
        }
        return pq.poll().get(0);
    }
}
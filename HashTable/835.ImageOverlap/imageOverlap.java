class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> La = new ArrayList<>();
        List<Integer> Lb = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; i++) {
            if (A[i / N][i % N] == 1) {
                La.add(i / N * 50 + i % N);
            }
        }
        for (int i = 0; i < N * N; i++) {
            if (B[i / N][i % N] == 1) {
                Lb.add(i / N * 50 + i % N);
            }
        }
        for (int i : La) {
            for (int j : Lb) {
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
            }
        }
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }
}
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] res = new int[n];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i < n; i++) {
            res[i] = Math.min(res[i - 1], res[i - 2]) + cost[i];
        }
        return Math.min(res[n - 1], res[n - 2]);
    }
}
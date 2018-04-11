class Solution {
    //dfs
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }
        int[][][] dp = new int[100][100][100];
        
        return dfs(boxes, dp, 0, boxes.length - 1, 0);
    }
    private int dfs(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }
        //first case
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        dp[l][r][k] = (k + 1) * (k + 1) + dfs(boxes, dp, l, r - 1, 0);
        
        //second case
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes, dp, i + 1, r - 1, 0) + dfs(boxes, dp, l, i, k + 1));
            }
        }
        return dp[l][r][k];
    }
}
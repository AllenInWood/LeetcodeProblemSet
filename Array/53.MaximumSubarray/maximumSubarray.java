class Solution {
    // Time Limit Exceeded
    // public int maxSubArray(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     int[][] dp = new int[nums.length][nums.length];
    //     int max = Integer.MIN_VALUE;
    //     for (int step = 0; step < nums.length; step++) {
    //         for (int i = 0; i < nums.length; i++) {
    //             if (i + step < nums.length) {
    //                 if (step == 0) {
    //                     dp[i][i + step] = nums[i];
    //                 } else {
    //                     dp[i][i + step] = dp[i + 1][i + step] + dp[i][i + step - 1] - dp[i + 1][i + step - 1];
    //                 }
    //                 max = Math.max(max, dp[i][i + step]);
    //             }
    //         }
    //     }
    //     return max;
    // }
    
    
    
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
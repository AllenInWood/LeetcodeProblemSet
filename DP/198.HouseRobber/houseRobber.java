class Solution {
    // public int rob(int[] nums) {
    //     int[][] dp = new int[nums.length + 1][2];
    //     for (int i = 1; i <= nums.length; i++) {
    //         dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
    //         dp[i][1] = nums[i - 1] + dp[i - 1][0];
    //     }
    //     return Math.max(dp[nums.length][0], dp[nums.length][1]);
    // }
    
    
    // public int rob(int[] nums) {
    //     int prevNo = 0;
    //     int prevYes = 0;
    //     for (int num : nums) {
    //         int temp = prevNo;
    //         prevNo = Math.max(prevNo, prevYes);
    //         prevYes = num + temp;
    //     }
    //     return Math.max(prevNo, prevYes);
    // }
    
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
        }
        return res[nums.length - 1];
    }
}
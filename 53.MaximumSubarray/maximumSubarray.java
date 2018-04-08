class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] local = new int[n];
        local[0] = nums[0];
        for (int i = 1; i < n; i++) {
            local[i] = Math.max(local[i - 1] + nums[i], nums[i]);
        }
        
        int[] global = new int[n];
        global[0] = nums[0];
        for (int i = 1; i < n; i++) {
            global[i] = Math.max(global[i - 1], local[i]);
        }
        return global[n - 1];
    }
}
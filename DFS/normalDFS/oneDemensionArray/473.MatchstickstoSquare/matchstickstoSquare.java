class Solution {
    public boolean makesquare(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0
            || nums.length < 4) {
            return false;
        }
        long width = sum / 4;
        Arrays.sort(nums);
        long[] sums = new long[4];
        return helper(nums, nums.length - 1, sums, width);
    }
    private boolean helper(int[] nums, int end, long[] sum, long width) {
        if (sum[0] > width || sum[1] > width
            || sum[2] > width || sum[3] > width) {
            return false;
        }
        if (end == -1) {
            if (sum[0] == width && sum[1] == width
                && sum[2] == width && sum[3] == width) {
                return true;
            } else {
                return false;
            }
        }
        for (int j = 0; j < 4; j++) {
            sum[j] += nums[end];
            if (helper(nums, end - 1, sum, width)) {
                return true;
            }
            sum[j] -= nums[end];
        }
        return false;
    }
}
class Solution {
    int[] sign = {1, -1};
    int count;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        count = 0;
        dfs(nums, 0, n, 0, S);
        return count;
    }
    private void dfs(int[] nums, int start, int n, int curSum, int S) {
        if (start == n) {
            if (curSum == S) {
                count++;
            }
            return;
        }
        for (int si : sign) {
            dfs(nums, start + 1, n, curSum + si * nums[start], S);
        }
    }
}
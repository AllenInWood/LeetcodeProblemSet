class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }
        int res = 0;
        for (int c : count) {
            res = Math.max(res, c);
        }
        return res;
    }
}
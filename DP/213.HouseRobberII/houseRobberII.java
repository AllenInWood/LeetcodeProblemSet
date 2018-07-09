class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robFun(nums, 1, nums.length - 1),
                        robFun(nums, 0, nums.length - 2));
    }
    private int robFun(int[] nums, int low, int high) {
        int preNo = 0, preYes = 0;
        for (int i = low; i <= high; i++) {
            int temp = preNo;
            preNo = Math.max(preNo, preYes);
            preYes = nums[i] + temp;
        }
        return Math.max(preNo, preYes);
    }
}
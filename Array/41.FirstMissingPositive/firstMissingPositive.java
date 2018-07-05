class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int[] newNums = new int[nums.length];
        Arrays.fill(newNums, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                newNums[nums[i] - 1] = nums[i];
            }
        }
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
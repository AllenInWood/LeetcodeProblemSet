class Solution {
    // very classical
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        // low + 1 < high
        while (low + 1 < high) {
            // int mid = low + (high - low) / 2;
            int mid = low + (high - low) / 2;
            // only two branches
            // left
            if (nums[mid] > nums[nums.length - 1]) {
                low = mid;
            } else {// right
                high = mid;
            }
        }
        // judge after while
        if (nums[high] < nums[low]) {
            return nums[high];
        }
        return nums[low];
    }
}
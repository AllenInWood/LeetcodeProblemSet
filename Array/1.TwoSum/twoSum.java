class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int[] res = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                res[1] = indexMap.get(target - nums[i]);
                res[0] = i;
                return res;
            }
            indexMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        int gap = (int) Math.ceil((double) (max - min) / (len - 1));
        int[] bucketsMin = new int[len - 1];
        int[] bucketsMax = new int[len - 1];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            int bucket = (num - min) / gap;
            bucketsMin[bucket] = Math.min(bucketsMin[bucket], num);
            bucketsMax[bucket] = Math.max(bucketsMax[bucket], num);
        }
        
        int res = Integer.MIN_VALUE;
        int pre = min;
        for (int i = 0; i < len - 1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(res, bucketsMin[i] - pre);
            pre = bucketsMax[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}
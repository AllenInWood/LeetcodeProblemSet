class Solution {
    // public boolean containsDuplicate(int[] nums) {
    //     if (nums.length == 0) {
    //         return false;
    //     }
    //     Map<Integer, Integer> hash = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (!hash.containsKey(nums[i])) {
    //             hash.put(nums[i], 1);
    //         } else {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
    
    //sort method
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
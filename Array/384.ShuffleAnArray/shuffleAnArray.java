class Solution {
    int[] original;
    Random random;

    public Solution(int[] nums) {
        original = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (original == null) {
            return null;
        }
        int[] temp = original.clone();
        for (int j = 1; j < temp.length; j++) {
            int i = random.nextInt(j + 1);
            swap(temp, i, j);
        }
        return temp;
    }
    
    private void swap(int[] temp, int i, int j) {
        int t = temp[i];
        temp[i] = temp[j];
        temp[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
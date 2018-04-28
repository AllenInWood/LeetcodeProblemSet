class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k <= 0 || t < 0) {
            return false;
        }
        valuePair[] vp = new valuePair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            vp[i] = new valuePair(nums[i], i);
        }
        Arrays.sort(vp, new Comparator<valuePair>() {
            public int compare(valuePair o1, valuePair o2) {
                if (o1.val == o2.val) {
                    return 0;
                } else if (o1.val < o2.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < vp.length; i++) {
            for (int j = i + 1; j < vp.length && ((long) vp[j].val - (long) vp[i].val <= (long) t); j++) {
                if ((Math.abs(vp[j].index - vp[i].index)) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}

class valuePair{
    int val;
    int index;
    
    valuePair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
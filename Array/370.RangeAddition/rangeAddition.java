class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        if (updates == null || updates.length == 0 || updates[0].length == 0) {
            return ans;
        }
        int si = 0, ei = 0, inc = 0;
        for (int[] update : updates) {
            si = update[0];
            ei = update[1];
            inc = update[2];
            if (si >= 1) {
                ans[si - 1] -= inc;
            }
            ans[ei] += inc;
        }
        for (int i = ans.length - 2; i >= 0; i--) {
            ans[i] += ans[i + 1];
        }
        return ans;
    }
}
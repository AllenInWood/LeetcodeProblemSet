class Solution {
    public int countBinarySubstrings(String s) {
        int curCount = 1, preCount = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curCount++;
            } else {
                preCount = curCount;
                curCount = 1;
            }
            if (preCount >= curCount) {
                res++;
            }
        }
        return res;
    }
}
class Solution {
    // int maxLen;
    // int low;
    // public String longestPalindrome(String s) {
    //     if (s == null || s.length() < 2) {
    //         return s;
    //     }
    //     maxLen = 0;
    //     low = 0;
    //     for (int i = 0; i < s.length() - 1; i++) {
    //         extendPalindrome(s, i, i);
    //         extendPalindrome(s, i, i + 1);
    //     }
    //     return s.substring(low, low + maxLen);
    // }
    // private void extendPalindrome(String s, int j, int k) {
    //     while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
    //         j--;
    //         k++;
    //     }
    //     if (maxLen < k - j - 1) {
    //         low = j + 1;
    //         maxLen = k - j - 1;
    //     }
    // }
    
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 0 || (s.charAt(j) == s.charAt(j + i))
                    && (i == 1 || dp[j + 1][j + i - 1])) {
                    dp[j][j + i] = true;
                    maxStart = j;
                    maxEnd = j + i;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
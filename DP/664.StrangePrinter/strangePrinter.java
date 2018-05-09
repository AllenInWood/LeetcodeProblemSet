/*
s:    abc ..... d
index:i ...k ...j
f(i, j) min steps to print s
f(i, j) worst case j - i + 1
f(i, j) = min(f(i, k) + f(k + 1, j)) - 1 if (s[k] == s[j]) (i <= k < j)
*/
class Solution {
    // public int strangePrinter(String s) {
    //     if (s.length () == 0) {
    //         return 0;
    //     }
    //     int len = s.length();
    //     int[][] dp = new int[len][len];
    //     for (int i = 0; i < len; i++) {
    //         dp[i][i] = 1;
    //     }
    //     for (int j = 1; j < len; j++) {
    //         for (int i = 0; i + j < len; i++) {
    //             dp[i][i + j] = j + 1;// worst case i + j - i + 1
    //             for (int k = i; k < i + j; k++) {
    //                 int total = dp[i][k] + dp[k + 1][i + j];
    //                 if (s.charAt(k) == s.charAt(i + j)) {
    //                     total--;
    //                 }
    //                 dp[i][i + j] = Math.min(dp[i][i + j], total);
    //             }
    //         }
    //     }
    //     return dp[0][len - 1];
    // }
    
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        return turn(s.toCharArray(), dp, 0, len - 1);
    }
    private int turn(char[] s, int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int ans = turn(s, dp, i, j - 1) + 1;
        for (int k = i; k < j; k++) {
            if (s[k] == s[j]) {
                ans = Math.min(ans, turn(s, dp, i, k) + turn(s, dp, k + 1, j - 1));
            }
        }
        dp[i][j] = ans;
        return ans;
    }
}
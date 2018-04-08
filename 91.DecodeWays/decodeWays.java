class Solution {
    //DFS way:
    // int count;
    // public int numDecodings(String s) {
    //     count = 0;
    //     restoreNum(s, "", 0);
    //     return count;
    // }
    // private void restoreNum(String s, String temp, int index) {
    //     if (temp != "" && index == s.length()) {
    //         count++;
    //     }
    //     for (int i = 1; i <= 2; i++) {
    //         if (index + i > s.length()) {
    //             break;
    //         }
    //         String t = s.substring(index, index + i);
    //         if (t.startsWith("0") || (i == 2 && Integer.parseInt(t) > 26)) {
    //             continue;
    //         }
    //         restoreNum(s, temp + t + ".", index + i);
    //     }
    // }
    
    
    //DP way:
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
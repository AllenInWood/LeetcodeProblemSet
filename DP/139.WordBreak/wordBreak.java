class Solution {
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     boolean[] dp = new boolean[s.length() + 1];
    //     dp[0] = true;
    //     for (int i = 1; i <= s.length(); i++) {
    //         for (String str : wordDict) {
    //             if (str.length() <= i) {
    //                 if (dp[i - str.length()]) {
    //                     if (s.substring(i - str.length(), i).equals(str)) {
    //                         dp[i] = true;
    //                         break;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return dp[s.length()];
    // }
    
    //dfs
    Set<String> hash;
    Map<String, Boolean> cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        hash = new HashSet<>();
        cache = new HashMap<>();
        for (String word : wordDict) {
            hash.add(word);
        }
        return dfs(s);
    }
    private boolean dfs(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean res;
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length(); i >= 0; i--) {
            String left = s.substring(0, i).toString();
            String right = s.substring(i).toString();
            if (hash.contains(left)) {
                if (cache.containsKey(right)) {
                    return cache.get(right);
                } else {
                    res = dfs(right);
                    cache.put(right, res);
                }
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }
}
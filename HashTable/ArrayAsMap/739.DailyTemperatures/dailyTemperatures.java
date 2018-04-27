class Solution {
    // public int[] dailyTemperatures(int[] temperatures) {
    //     if (temperatures == null || temperatures.length == 0) {
    //         return null;
    //     }
    //     int[] ans = new int[temperatures.length];
    //     Arrays.fill(ans, 0);
    //     for (int i = 0; i < temperatures.length; i++) {
    //         for (int j = i + 1; j < temperatures.length; j++) {
    //             if (temperatures[j] > temperatures[i]) {
    //                 ans[i] = j - i;
    //                 break;
    //             }
    //         }
    //     }
    //     return ans;
    // }
    
    
    
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }
        int[] ans = new int[temperatures.length];
        int[] map = new int[101];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            map[temperatures[i]] = i;
            int min = 30001;
            for (int j = temperatures[i] + 1; j <= 100; j++) {
                if (map[j] != 0) {
                    min = Math.min(min, map[j]);
                }
            }
            ans[i] = min == 30001 ? 0 : min - i;
        }
        return ans;
    }
}
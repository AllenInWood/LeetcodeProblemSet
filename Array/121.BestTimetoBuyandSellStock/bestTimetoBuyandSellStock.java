class Solution {
    // public int maxProfit(int[] prices) {
    //     if (prices == null || prices.length == 0) {
    //         return 0;
    //     }
    //     int minPrice = Integer.MAX_VALUE;
    //     int maxValue = 0;
    //     for (int i = 0; i < prices.length; i++) {
    //         minPrice = Math.min(minPrice, prices[i]);
    //         maxValue = Math.max(maxValue, prices[i] - minPrice);
    //     }
    //     return maxValue;
    // }
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int bought = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bought) {
                if (ans < prices[i] - bought) {
                    ans = prices[i] - bought;
                }
            } else {
               bought = prices[i]; 
            }
        }
        return ans;
    }
}
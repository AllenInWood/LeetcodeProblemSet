class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        int tran = 0;
        int pre = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (i != prices.length - 1 && prices[i] > prices[i + 1]) {
                tran = prices[i] - pre;
                pre = prices[i + 1];
                res += tran;
            }
            if (i ==  prices.length - 1) {
                tran = prices[i] - pre;
                pre = 0;
                res += tran;
            }
        }
        return res;
    }
}
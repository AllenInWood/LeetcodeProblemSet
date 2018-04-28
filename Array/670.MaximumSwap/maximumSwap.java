class Solution {
    public int maximumSwap(int num) {
        char[] digits = ("" + num).toCharArray();
        int firstGreater = 0;
        while (++firstGreater < digits.length
               && digits[firstGreater - 1] >= digits[firstGreater]);
        if (firstGreater >= digits.length) {
            return num;
        }
        char max = '0';
        int maxIndex = firstGreater;
        for (int i = firstGreater; i < digits.length; i++) {
            if (digits[i] >= max) {
                max = digits[i];
                maxIndex = i;
            }
        }
        for(int i = 0; i < firstGreater; i++) {
            if (max > digits[i]) {
                StringBuilder s = new StringBuilder(String.valueOf(digits));
                s.setCharAt(maxIndex, digits[i]);
                s.setCharAt(i, max);
                return Integer.parseInt(s.toString());
            }
        }
        return num;
    }
}
class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n == 0 || n == 1) {
            return true;
        }
        n = n ^ (n >> 1);
        return (n & (n + 1)) == 0;
    }
}
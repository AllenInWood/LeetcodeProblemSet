class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (sb.length() > 0
                   && sb.charAt(sb.length() - 1) > num.charAt(i)
                   && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num.charAt(i));
        }
        if (k > 0) {
            sb.delete(sb.length() - k, sb.length());
        }
        // delete leading zeros
        int s = -1;
        while (++s < sb.length() && sb.charAt(s) == '0');
        String res = sb.substring(s, sb.length());
        return res.equals("") ? "0" : res;
    }
}
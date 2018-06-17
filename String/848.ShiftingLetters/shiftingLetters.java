class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        int pre = 0;
        int temp;
        for (int i = shifts.length - 1; i >= 0; i--) {
            temp = (shifts[i] + pre) % 26;
            chars[i] = (char) ((((chars[i] + temp) % 'a') % 26 ) + 'a');
            pre = temp;
        }
        return new String(chars);
    }
}
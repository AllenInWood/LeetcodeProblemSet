class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int flag = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len++;
                flag = 0;
            } else {
                if (flag == 0) {
                    return len;
                }
            }
        }
        return len;
    }
}
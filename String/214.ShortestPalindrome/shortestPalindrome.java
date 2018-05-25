class Solution {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
    
    // alternative isPalindrome function
    // public String shortestPalindrome(String s) {
    //     if (s == null || s.length() == 0) {
    //         return s;
    //     }
    //     int j = s.length();
    //     while (j >= 0) {
    //         if (isPalindrome(s.substring(0, j))) {
    //             break;
    //         }
    //         j--;
    //     }
    //     if (j != s.length()) {
    //         String ans = new StringBuilder(s.substring(j)).reverse().toString() + s;
    //         return ans;
    //     }
    //     return s;
    // }
    // private boolean isPalindrome(String string) {
    //     if (string.length() == 0) {
    //         return true;
    //     }
    //     int i = 0, j = string.length() - 1;
    //     while (i < j) {
    //         if (string.charAt(i++) != string.charAt(j--)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
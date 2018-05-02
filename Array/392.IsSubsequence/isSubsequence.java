class Solution {
    // public boolean isSubsequence(String s, String t) {
    //     if (s == null || s.length() == 0) {
    //         return true;
    //     }
    //     char[] sArray = s.toCharArray();
    //     int pos = sArray.length - 1;
    //     String temp = t;
    //     int index = temp.lastIndexOf(sArray[pos]);
    //     while (index != -1) {
    //         if (pos == 0) {
    //             return true;
    //         }
    //         pos--;
    //         temp = temp.substring(0, index);
    //         index = temp.lastIndexOf(sArray[pos]);
    //     }
    //     return false;
    // }
    
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] sArrays = s.toCharArray();
        int index = sArrays.length - 1;
        for (int i = t.length() - 1; i >= 0; i--) {
            if (index >= 0 && sArrays[index] == t.charAt(i)) {
                index--;
            }
        }
        if (index < 0) {
            return true;
        }
        return false;
    }
}
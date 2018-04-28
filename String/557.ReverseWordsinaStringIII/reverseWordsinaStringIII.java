class Solution {
    // public String reverseWords(String s) {
    //     if (s == null || s.length() == 0) {
    //         return "";
    //     }
    //     String[] words = s.split(" ");
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < words.length; i++) {
    //         for (int j = words[i].length() - 1; j >= 0; j--) {
    //             sb.append(words[i].charAt(j));
    //         }
    //         if (i != words.length - 1) {
    //             sb.append(' ');
    //         }
    //     }
    //     return sb.toString();
    // }
    
    
    //in place
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                add(start, i - 1, chars);
                start = i + 1;
            }
        }
        add(start, chars.length - 1, chars);
        return String.valueOf(chars);
    }
    private void add(int start, int end, char[] chars) {
        int i = start;
        int j = end;
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
    }
}
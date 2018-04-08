class Solution {
    // public String reverseString(String s) {
    //     return new StringBuilder(s).reverse().toString();
    // }
    
    public String reverseString(String s) {
        char[] words = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        return new String(words);
    }
}
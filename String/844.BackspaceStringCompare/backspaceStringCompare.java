class Solution {
    // front to end point
    // public boolean backspaceCompare(String S, String T) {
    //     return delBackspace(S).equals(delBackspace(T));
    // }
    // private String delBackspace(String str) {
    //     StringBuilder sb = new StringBuilder();
    //     for (char c : str.toCharArray()) {
    //         if (c != '#') {
    //             sb.append(c);
    //         } else {
    //             if (sb.length() > 0) {
    //                 sb.deleteCharAt(sb.length() - 1);
    //             }
    //         }
    //     }
    //     return sb.toString();
    // }
    
    
    // end to front point
    // public boolean backspaceCompare(String S, String T) {
    //     return delBackspace(S).equals(delBackspace(T));
    // }
    // private String delBackspace(String str) {
    //     String ans = "";
    //     int backCount = 0;
    //     for (int i = str.length() - 1; i >= 0;) {
    //         if (str.charAt(i) == '#') {
    //             while (i >= 0 && str.charAt(i) == '#') {
    //                 i--;
    //                 backCount++;
    //             }
    //         } else {
    //             if (backCount > 0) {
    //                 backCount--;
    //             } else {
    //                 ans = str.charAt(i) + ans;
    //             }
    //             i--;
    //         }
    //     }
    //     return ans;
    // }
    
    
    // stack
    public boolean backspaceCompare(String S, String T) {
        return delBackspace(S).equals(delBackspace(T));
    }
    private String delBackspace(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
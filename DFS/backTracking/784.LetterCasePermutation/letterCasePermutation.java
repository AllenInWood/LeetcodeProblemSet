class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        ans.add(S);
        backtracking(S, S, ans, 0);
        return ans;
    }
    private void backtracking(String S, String temp, List<String> ans, int start) {
        if (start == S.length()) {
            return;
        }
        if (Character.isDigit(S.charAt(start))) {
            backtracking(S, temp, ans, start + 1);
        } else {
            if (S.charAt(start) >= 'a') {
                backtracking(S, temp, ans, start + 1);
                temp = temp.substring(0, start) + Character.toUpperCase(S.charAt(start)) + temp.substring(start + 1);
                ans.add(temp);
                backtracking(S, temp, ans, start + 1);
            } else {
                backtracking(S, temp, ans, start + 1);
                temp = temp.substring(0, start) + Character.toLowerCase(S.charAt(start)) + temp.substring(start + 1);
                ans.add(temp);
                backtracking(S, temp, ans, start + 1);
            }
        }
    }
}
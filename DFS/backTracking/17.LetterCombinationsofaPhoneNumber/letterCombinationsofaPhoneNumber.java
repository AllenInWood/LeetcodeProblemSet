class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        combination(ans, new StringBuilder(), digits, 0);
        return ans;
    }
    private void combination(List<String> ans, StringBuilder sb, String digits, int index) {
        if (index >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String key = KEYS[digits.charAt(index) - '0'];
        for (int j = 0; j < key.length(); j++) {
            sb.append(key.charAt(j));
            combination(ans, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        if (S.length() < 3) {
            return ans;
        }
        backtracking(S, ans, 0);
        return ans;
    }
    private boolean backtracking(String S, List<Integer> ans, int start) {
        if (start == S.length()) {
            if (ans.size() >= 3) {
                return true;
            }
            return false;
        }
        for (int i = start; i < S.length(); i++) {
            if (S.charAt(start) == '0' && i > start) {
                break;
            }
            long cur = Long.valueOf(S.substring(start, i + 1));
            if (cur > Integer.MAX_VALUE) {
                break;
            }
            int size = ans.size();
            if (size <= 1 || cur == ans.get(size - 1)
                + ans.get(size - 2)) {
                ans.add((int) cur);
                if (backtracking(S, ans, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}
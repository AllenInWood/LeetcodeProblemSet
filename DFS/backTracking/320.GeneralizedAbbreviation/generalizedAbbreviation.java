class Solution {
    // maintain history
    // public List<String> generateAbbreviations(String word) {
    //     Set<String> ans = new HashSet<>();
    //     Stack<String> history = new Stack<>();
    //     dfs(word, "", history, ans, 0);
    //     return new ArrayList<>(ans);
    // }
    // private void dfs(String word, String temp, Stack<String> history, Set<String> ans, int idx) {
    //     if (idx == word.length()) {
    //         ans.add(temp);
    //         return;
    //     }
    //     for (int i = idx; i < word.length(); i++) {
    //         int num = i - idx + 1;
    //         if (temp.length() == 0) {
    //             history.push("" + num);
    //             dfs(word, temp + num, history, ans, i + 1);
    //             history.pop();
    //             history.push(word.substring(idx, i + 1));
    //             dfs(word, temp + word.substring(idx, i + 1), history, ans, i + 1);
    //             history.pop();
    //         } else {
    //             if (Character.isDigit(history.peek().charAt(0))) {
    //                 history.push(word.substring(idx, i + 1));
    //                 dfs(word, temp + word.substring(idx, i + 1), history, ans, i + 1);
    //                 history.pop();
    //             } else {
    //                 history.push("" + num);
    //                 dfs(word, temp + num, history, ans, i + 1);
    //                 history.pop();
    //             }
    //         }
    //     }
    // }
    
    // without history, must add char after add a number
    // cache the temporary String length
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        dfs(ans, word, "", 0, 0);
        return ans;
    }
    private void dfs(List<String> ans, String word, String cur, int pos, int count) {
        if (pos == word.length()) {
            if (count > 0) {
                cur = cur + count;
            }
            ans.add(cur);
            return;
        }
        dfs(ans, word, cur, pos + 1, count + 1);
        dfs(ans, word, cur + (count == 0 ? "" : count) + word.charAt(pos), pos + 1, 0);
    }
}
class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0
            || words == null || words.length == 0) {
            return ans;
        }
        TrieNode root = buildTrie(words);
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWords(ans, board, i, j, m, n, root);
            }
        }
        return ans;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new TrieNode();
                }
                cur = cur.next[index];
            }
            cur.word = word;
        }
        return root;
    }
    private void findWords(List<String> ans, char[][] board, int i, int j, int m, int n, TrieNode root) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        root = root.next[c - 'a'];
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            findWords(ans, board, x, y, m, n, root);
        }
        board[i][j] = c;
    }
}
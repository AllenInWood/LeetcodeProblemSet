class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        TrieNode root = buildTrie(words);
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        String ans = "";
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TrieNode cur = queue.poll();
                if (cur.word != null) {
                    ans = cur.word;
                }
                for (int i = 25; i >= 0; i--) {
                    if (cur.children[i] != null && cur.children[i].word != null) {
                        queue.offer(cur.children[i]);
                    }
                }
            }
        }
        return ans;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    cur.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
}
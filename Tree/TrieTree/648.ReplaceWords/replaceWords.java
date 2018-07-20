class Solution {
    class TrieNode {
        String val;
        TrieNode[] children;
        public TrieNode() {
            val = null;
            children = new TrieNode[26];
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) {
            return null;
        }
        TrieNode root = buildTrie(dict);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String temp = hasPrefix(root, words[i]);
            sb.append(temp);
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String d : dict) {
            TrieNode cur = root;
            for (int i = 0; i < d.length(); i++) {
                if (cur.children[d.charAt(i) - 'a'] == null) {
                    cur.children[d.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.children[d.charAt(i) - 'a'];
            }
            cur.val = d;
        }
        return root;
    }
    private String hasPrefix(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.val != null) {
                return cur.val;
            }
            if (cur.children[word.charAt(i) - 'a'] != null) {
                cur = cur.children[word.charAt(i) - 'a'];
            } else {
                return word;
            }
        }
        return word;
    }
}
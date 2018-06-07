class WordDictionary {
    // TrieTree
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chars, int k, TrieNode node) {
        if (k == chars.length) {
            return !node.item.equals("");
        }
        if (chars[k] != '.') {
            return node.children[chars[k] - 'a'] != null
                && match(chars, k + 1, node.children[chars[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chars, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
            // Time Limit Exceeded
//     Set<String> set;

//     /** Initialize your data structure here. */
//     public WordDictionary() {
//         set = new HashSet<>();
//     }
    
//     /** Adds a word into the data structure. */
//     public void addWord(String word) {
//         set.add(word);
//     }
    
//     /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//     public boolean search(String word) {
//         for (String s : set) {
//             if (match(word, s)) {
//                 return true;
//             }
//         }
//         return false;
//     }
    
//     private boolean match(String word, String s) {
//         if (word.length() != s.length()) {
//             return false;
//         }
//         int i = 0, j = 0;
//         while (i < word.length()) {
//             if (word.charAt(i) == '.') {
//                 i++;
//                 j++;
//             } else {
//                 if (word.charAt(i) != s.charAt(j)) {
//                     return false;
//                 }
//                 i++;
//                 j++;
//             }
//         }
//         return true;
//     }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
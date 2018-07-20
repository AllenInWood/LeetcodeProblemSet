class Solution {
    // Trie
    
    // class TrieNode {
    //     int frequency;
    //     String word;
    //     TrieNode[] children;
    //     public TrieNode() {
    //         children = new TrieNode[26];
    //         word = null;
    //         frequency = 0;
    //     }
    // }
    // class TrieEntry{
    //     String word;
    //     int frequency;
    //     public TrieEntry(String word, int frequency) {
    //         this.word = word;
    //         this.frequency = frequency;
    //     }
    // }
    // PriorityQueue<TrieEntry> queue;
    // public List<String> topKFrequent(String[] words, int k) {
    //     List<String> ans = new ArrayList<>();
    //     if (words == null || words.length == 0) {
    //         return ans;
    //     }
    //     queue = new PriorityQueue<>(new Comparator<TrieEntry>() {
    //         public int compare(TrieEntry o1, TrieEntry o2) {
    //             if (o1.frequency == o2.frequency) {
    //                 return o1.word.compareTo(o2.word);
    //             }
    //             return o2.frequency - o1.frequency;
    //         }
    //     });
    //     TrieNode root = buildTrie(words);
    //     if (k > queue.size()) {
    //         return ans;
    //     }
    //     while (!queue.isEmpty() && k != 0) {
    //         ans.add(queue.poll().word);
    //         k--;
    //     }
    //     return ans;
    // }
    // private TrieNode buildTrie(String[] words) {
    //     TrieNode root = new TrieNode();
    //     Map<String, Integer> map = new HashMap<>();
    //     for (String word : words) {
    //         TrieNode cur = root;
    //         for (int i = 0; i < word.length(); i++) {
    //             if (cur.children[word.charAt(i) - 'a'] == null) {
    //                 cur.children[word.charAt(i) - 'a'] = new TrieNode();
    //             }
    //             cur = cur.children[word.charAt(i) - 'a'];
    //         }
    //         cur.word = word;
    //         cur.frequency++;
    //         map.put(cur.word, cur.frequency);
    //     }
    //     for (String key : map.keySet()) {
    //         queue.offer(new TrieEntry(key, map.get(key)));
    //     }
    //     return root;
    // }
    
    
    
    // Map
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
            new Comparator<Map.Entry<String, Integer>>(){
                 public int compare(Map.Entry<String, Integer> o1,
                                    Map.Entry<String, Integer> o2) {
                     return o1.getValue() == o2.getValue()
                         ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue();
                 }
            }
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        while (!queue.isEmpty() && k != 0) {
            ans.add(queue.poll().getKey());
            k--;
        }
        return ans;
    }
}
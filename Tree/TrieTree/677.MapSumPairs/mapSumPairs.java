class MapSum {
    class TrieNode {
        String word;
        int sum;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            if (cur.children[key.charAt(i) - 'a'] == null) {
                cur.children[key.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[key.charAt(i) - 'a'];
        }
        cur.word = key;
        cur.sum = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children[prefix.charAt(i) - 'a'] != null) {
                cur = cur.children[prefix.charAt(i) - 'a'];
            } else {
                return 0;
            }
        }
        return bfs(cur);
    }
    
    private int bfs(TrieNode node) {
        int sum = 0;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TrieNode cur = queue.poll();
                if (cur.sum != 0) {
                    sum += cur.sum;
                }
                for (int i = 25; i >= 0; i--) {
                    if (cur.children[i] != null) {
                        queue.offer(cur.children[i]);
                    }
                }
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
class Solution {
    class TrieNode {
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TrieNode root = buildTrie(nums);
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            TrieNode cur = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (cur.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    cur = cur.children[curBit ^ 1];
                } else {
                    cur = cur.children[curBit];
                }
                if (curSum < max && max - curSum >= (1 << i) - 1) {
                    break;
                }
            }
            max = Math.max(max, curSum);
        }
        return max;
    }
    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (cur.children[curBit] == null) {
                    cur.children[curBit] = new TrieNode();
                }
                cur = cur.children[curBit];
            }
        }
        return root;
    }
}
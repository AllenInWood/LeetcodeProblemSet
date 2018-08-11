class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).offer(word);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            Queue<String> queue = map.get(c);
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).offer(word.substring(1));
                }
            }
        }
        return count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> curSet = new HashSet<>();
        Set<String> endSet = new HashSet<>(wordList);
        
        if (!endSet.contains(endWord)) {
            return 0;
        }
        curSet.add(beginWord);
        int distance = 1;
        while (!curSet.contains(endWord)) {
            Set<String> next = new HashSet<>();
            for (String word : curSet) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String s = new String(chars);
                        if (endSet.contains(s)) {
                            next.add(s);
                            endSet.remove(s);
                        }
                    }
                }
            }
            distance++;
            if (next.size() == 0) {
                return 0;
            }
            curSet = next;
        }
        return distance;
    }
}
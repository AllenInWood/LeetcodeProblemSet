class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> curSet = new HashSet<>();
//         Set<String> endSet = new HashSet<>(wordList);
        
//         if (!endSet.contains(endWord)) {
//             return 0;
//         }
//         curSet.add(beginWord);
//         int distance = 1;
//         while (!curSet.contains(endWord)) {
//             Set<String> next = new HashSet<>();
//             for (String word : curSet) {
//                 for (int i = 0; i < word.length(); i++) {
//                     char[] chars = word.toCharArray();
//                     for (char ch = 'a'; ch <= 'z'; ch++) {
//                         chars[i] = ch;
//                         String s = new String(chars);
//                         if (endSet.contains(s)) {
//                             next.add(s);
//                             endSet.remove(s);
//                         }
//                     }
//                 }
//             }
//             distance++;
//             if (next.size() == 0) {
//                 return 0;
//             }
//             curSet = next;
//         }
//         return distance;
//     }
    
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Queue<String> queue = new LinkedList<>();
//         queue.offer(beginWord);
        
//         Set<String> endSet = new HashSet<>();
//         for (String word : wordList) {
//             endSet.add(word);
//         }
//         if (!endSet.contains(endWord)) {
//             return 0;
//         }
//         int level = 1;
//         while (!queue.contains(endWord)) {
//             int size = queue.size();
//             while (size-- > 0) {
//                 String cur = queue.poll();
//                 for (int i = 0; i < cur.length(); i++) {
//                     char[] chars = cur.toCharArray();
//                     for (char ch = 'a'; ch <= 'z'; ch++) {
//                         chars[i] = ch;
//                         String s = new String(chars);
//                         if (endSet.contains(s)) {
//                             queue.offer(s);
//                             endSet.remove(s);
//                         }
//                     }
//                 }
//             }
//             level++;
//             if (queue.size() == 0) {
//                 return 0;
//             }
//         }
//         return level;
//     }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> cur = new ArrayList<>();
        cur.add(beginWord);
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        if (!dict.contains(endWord)) {
            return 0;
        }
        int level = 1;
        while (!cur.contains(endWord)) {
            int size = cur.size();
            List<String> next = new ArrayList<>();
            for (String s : cur) {
                for (int i = 0; i < s.length(); i++) {
                    char[] chars = s.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String s1 = new String(chars);
                        if (dict.contains(s1)) {
                            next.add(s1);
                            dict.remove(s1);
                        }
                    }
                }
            }
            level++;
            if (next.size() == 0) {
                return 0;
            }
            cur = next;
        }
        return level;
    }
}
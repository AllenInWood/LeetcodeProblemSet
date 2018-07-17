class Solution {
    // DFS
    // int minStep;
    // List<List<String>> minAns;
    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     List<List<String>> ans = new ArrayList<>();
    //     if (wordList == null || wordList.size() == 0) {
    //         return ans;
    //     }
    //     minStep = Integer.MAX_VALUE;
    //     minAns = new ArrayList<>();
    //     List<String> temp = new ArrayList<>();
    //     temp.add(beginWord);
    //     dfs(ans, temp, new HashSet<>(), beginWord, endWord, new HashSet<>(wordList));
    //     for (List<String> path : ans) {
    //         if (path.size() == minStep) {
    //             minAns.add(path);
    //         }
    //     }
    //     return minAns;
    // }
    // private void dfs(List<List<String>> ans, List<String> temp, Set<String> visited,
    //                  String beginWord, String endWord, Set<String> wordSet) {
    //     if (endWord.equals(beginWord)) {
    //         minStep = Math.min(minStep, temp.size());
    //         ans.add(new ArrayList<>(temp));
    //         return;
    //     } else{
    //         for (int i = 0; i < beginWord.length(); i++) {
    //             for (char c = 'a'; c <= 'z'; c++) {
    //                 char[] chars = beginWord.toCharArray();
    //                 chars[i] = c;
    //                 String next = new String(chars);
    //                 if (wordSet.contains(next) && !visited.contains(next)) {
    //                     temp.add(next);
    //                     visited.add(next);
    //                     dfs(ans, temp, visited, next, endWord, wordSet);
    //                     visited.remove(next);
    //                     temp.remove(temp.size() - 1);
    //                 }
    //             }
    //         }
    //     }
    // }
    
    
    
    
    // BFS
    // class Node {
    //     String cur;
    //     List<String> history;
    //     Set<String> visited;
    //     Node(String cur, List<String> history, Set<String> visited) {
    //         this.cur = cur;
    //         this.history = history;
    //         this.visited = visited;
    //     }
    // }
    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     List<List<String>> ans = new ArrayList<>();
    //     if (wordList == null || wordList.size() == 0) {
    //         return ans;
    //     }
    //     wordList.add(beginWord);
    //     bfs(ans, new ArrayList<>(), beginWord, endWord, new HashSet<>(wordList));
    //     return ans;
    // }
    // private void bfs(List<List<String>> ans, List<String> temp, String beginWord, String endWord, Set<String> wordSet) {
    //     Queue<Node> queue = new LinkedList<>();
    //     Set<String> visited = new HashSet<>();
    //     visited.add(beginWord);
    //     queue.offer(new Node(beginWord, new ArrayList<>(), visited));
    //     boolean isFound = false;
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         while (size-- > 0) {
    //             Node node = queue.poll();
    //             if (node.cur.equals(endWord)) {
    //                 node.history.add(node.cur);
    //                 ans.add(new ArrayList<>(node.history));
    //                 isFound = true;
    //             }
    //             if (!isFound) {
    //                 for (int i = 0; i < node.cur.length(); i++) {
    //                     for (char c = 'a'; c <= 'z'; c++) {
    //                         char[] chars = node.cur.toCharArray();
    //                         chars[i] = c;
    //                         String next = new String(chars);
    //                         if (wordSet.contains(next) && !node.history.contains(next)) {
    //                             List<String> nextHis = new ArrayList<>(node.history);
    //                             nextHis.add(node.cur);
    //                             Set<String> nextVis = new HashSet<>(node.visited);
    //                             nextVis.add(next);
    //                             queue.offer(new Node(next, nextHis, nextVis));
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //         if (isFound) {
    //             return;
    //         }
    //     }
    // }
    
    
    
    
    // BFS construct, DFS output
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> temp = new ArrayList<>();
        
        bfs(beginWord, endWord, dict, neighbors, distance);
        dfs(beginWord, endWord, dict, neighbors, distance, ans, temp);
        
        return ans;
    }
    
    private void bfs(String start, String end, Set<String> dict,
                     Map<String, List<String>> neighbors, Map<String, Integer> distance) {
        for (String word : dict) {
            neighbors.put(word, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            while (size-- > 0) {
                String cur = queue.poll();
                int cost = distance.get(cur);
                List<String> nexts = getAllNeighbors(cur, dict);
                for (String next : nexts) {
                    neighbors.get(cur).add(next);
                    if (!distance.containsKey(next)) {
                        distance.put(next, cost + 1);
                        if (end.equals(next)) {
                            found = true;
                        } else {
                            queue.offer(next);
                        }
                    }
                }

            }
            if (found) {
                return;
            }
        }
    }
    
    private List<String> getAllNeighbors(String cur, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < cur.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char[] chars = cur.toCharArray();
                if (chars[i] == c) continue;
                chars[i] = c;
                if (dict.contains(String.valueOf(chars))) {
                    res.add(String.valueOf(chars));
                }
            }
        }
        return res;
    }
    
    private void dfs(String start, String end, Set<String> dict, Map<String, List<String>> neighbors,
                     Map<String, Integer> distance, List<List<String>> ans, List<String> temp) {
        if (start.equals(end)) {
            temp.add(start);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        for (String next : neighbors.get(start)) {
            if (distance.get(next) == distance.get(start) + 1) {
                temp.add(start);
                dfs(next, end, dict, neighbors, distance, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
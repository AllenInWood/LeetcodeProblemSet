class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        Queue<Map.Entry<Character, Integer>> maxQueue = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> o1,
                                   Map.Entry<Character, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            }
        );
        
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxQueue.addAll(map.entrySet());
        
        StringBuilder ans = new StringBuilder();
        while (!maxQueue.isEmpty()) {
            Map.Entry<Character, Integer> curEntry = maxQueue.poll();
            ans.append(curEntry.getKey());
            curEntry.setValue(curEntry.getValue() - 1);
            waitQueue.offer(curEntry);
            if (waitQueue.size() < k) {
                continue;
            }
            Map.Entry<Character, Integer> reEnter = waitQueue.poll();
            if (reEnter.getValue() > 0) {
                maxQueue.offer(reEnter);
            }
        }
        return ans.length() == s.length() ? ans.toString() : "";
    }
}
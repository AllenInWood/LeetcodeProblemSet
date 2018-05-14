class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            queue.offer(cur);
            while (queue.size() > 1) {
                Map.Entry<Character, Integer> temp = queue.poll();
                if (temp.getValue() > 0) {
                    pq.offer(temp);
                }
            }
        }
        return sb.length() == S.length() ? sb.toString() : "";
    }
}
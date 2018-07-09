class Solution {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(A);
        visited.add(A);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                int i = 0;
                while (cur.charAt(i) == B.charAt(i)) {
                    i++;
                }
                for (int j = i + 1; j < cur.length(); j++) {
                    if (cur.charAt(j) == B.charAt(j) || cur.charAt(i) != B.charAt(j)) {
                        continue;
                    }
                    String temp = swap(cur, i, j);
                    if (temp.equals(B)) {
                        return res;
                    }
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        queue.offer(temp);
                    }
                }
            }
        }
        return res;
    }
    
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
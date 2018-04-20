class Solution {
    // public int openLock(String[] deadends, String target) {
    //     Queue<String> queue = new LinkedList<>();
    //     Set<String> dead = new HashSet<>(Arrays.asList(deadends));
    //     Set<String> visited = new HashSet<>();
    //     queue.offer("0000");
    //     visited.add("0000");
    //     int level = 0;
    //     if (dead.contains("0000")) {
    //         return -1;
    //     }
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         while (size-- > 0) {
    //             String s = queue.poll();
    //             if (s.equals(target)) {
    //                 return level;
    //             }
    //             StringBuilder sb = new StringBuilder(s);
    //             for (int i = 0; i < 4; i++) {
    //                 char c = s.charAt(i);
    //                 String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
    //                 String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
    //                 if (!visited.contains(s1) && !dead.contains(s1)) {
    //                     queue.offer(s1);
    //                     visited.add(s1);
    //                 }
    //                 if (!visited.contains(s2) && !dead.contains(s2)) {
    //                     queue.offer(s2);
    //                     visited.add(s2);
    //                 }
    //             }
    //         }
    //         level++;
    //     }
    //     return -1;
    // }
    
    
    //two way BFS
    public int openLock(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        begin.add("0000");
        end.add(target);
        visited.add("0000");
        if (dead.contains("0000")) {
            return -1;
        }
        int level = 0;
        while (!begin.isEmpty() && !end.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s)) {
                    return level;
                }
                visited.add(s);
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c = s.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!dead.contains(s1) && !visited.contains(s1)) {
                        temp.add(s1);
                    }
                    if (!dead.contains(s2) && !visited.contains(s2)) {
                        temp.add(s2);
                    }
                }
            }
            level++;
            begin = end;
            end = temp;
        }
        return -1;
    }
}
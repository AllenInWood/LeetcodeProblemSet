class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0
            || board[0].length == 0) {
            return -1;
        }
        int row = board.length, col = board[0].length;
        String goal = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append("" + board[i][j]);
            }
        }
        String start = sb.toString();
        if (goal.equals(start)) {
            return 0;
        }
        
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                int index = cur.indexOf('0');
                int x = index / col;
                int y = index % col;
                for (int[] dir : dirs) {
                    int x1 = x + dir[0];
                    int y1 = y + dir[1];
                    if (x1 < 0 || x1 >= row || y1 < 0 || y1 >= col) {
                        continue;
                    }
                    int index1 = x1 * col + y1;
                    String s = swap(cur, index, index1);
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (s.equals(goal)) {
                        return step;
                    }
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return -1;
    }
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
        return new String(chars);
    }
}
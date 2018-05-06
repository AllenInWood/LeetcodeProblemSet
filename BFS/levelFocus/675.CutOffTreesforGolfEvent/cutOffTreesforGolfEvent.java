class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return -1;
        }
        int m = forest.size(), n = forest.get(0).size();
        int ans = 0;
        List<int[]> heights = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // tree
                if (forest.get(i).get(j) > 1) {
                    heights.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int x = 0, y = 0;
        for (int i = 0; i < heights.size(); i++) {
            int levelStep = bfs(forest, m, n, x, y,
                                heights.get(i)[1], heights.get(i)[2]);
            if (levelStep == -1) {
                return -1;
            }
            ans += levelStep;
            x = heights.get(i)[1];
            y = heights.get(i)[2];
        }
        return ans;
    }
    private int bfs(List<List<Integer>> forest, int m, int n,
                    int sx, int sy, int ex, int ey) {
        if (sx == ex && sy == ey) {
            return 0;
        }
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        boolean[][] visited = new boolean[m][n];
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n
                        || forest.get(x).get(y) == 0 || visited[x][y]) {
                        continue;
                    }
                    if (x == ex && y == ey) {
                        return step;
                    }
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }
}
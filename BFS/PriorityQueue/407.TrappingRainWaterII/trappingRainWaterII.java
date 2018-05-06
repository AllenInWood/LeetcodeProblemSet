class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0
            || heightMap[0].length == 0) {
            return 0;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return Integer.compare(o1.height, o2.height);
            }
        });
        
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            visited[m - 1][i] = true;
            queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur.row + dir[0];
                int y = cur.col + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                res += Math.max(0, cur.height - heightMap[x][y]);
                queue.offer(new Cell(x, y, Math.max(cur.height, heightMap[x][y])));
            }
        }
        return res;
    }
}
class Cell {
    int row;
    int col;
    int height;
    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        int m = image.length, n = image[0].length;
        int[][] visited = new int[m][n];
        dfs(image, sr, sc, m, n, newColor, image[sr][sc], visited);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int m, int n, int newColor, int oldColor, int[][] visited) {
        image[i][j] = newColor;
        visited[i][j] = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != oldColor || visited[x][y] == 1) {
                continue;
            }
            dfs(image, x, y, m, n, newColor, oldColor, visited);
        }
    }
}
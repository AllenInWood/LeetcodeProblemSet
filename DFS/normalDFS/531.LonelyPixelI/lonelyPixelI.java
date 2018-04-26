class Solution {
    // public int findLonelyPixel(char[][] picture) {
    //     if (picture == null || picture.length == 0
    //         || picture[0].length == 0) {
    //         return 0;
    //     }
    //     int m = picture.length, n = picture[0].length;
    //     int ans = 0;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if(picture[i][j] == 'B'
    //                && dfs(picture, i, j, m, n)) {
    //                 ans++;
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // private boolean dfs(char[][] picture, int i, int j, int m, int n) {
    //     boolean res = true;
    //     for (int k = 0; k < m; k++) {
    //         if (k != i && picture[k][j] == 'B') {
    //             res = false;
    //         }
    //     }
    //     for (int k = 0 ; k < n; k++) {
    //         if (k != j && picture[i][k] == 'B') {
    //             res = false;
    //         }
    //     }
    //     return res;
    // }
    
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        int m = picture.length, n = picture[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    if (dfs(picture, i, j, m, n, new boolean[m][n])) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    private boolean dfs(char[][] picture, int i, int j, int m, int n, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i;
            int y = j;
            while (x + dir[0] >= 0 && x + dir[0] < m && y + dir[1] >= 0
                   && y + dir[1] < n && visited[x + dir[0]][y + dir[1]] == false) {
                x += dir[0];
                y += dir[1];
                if (picture[x][y] == 'B') {
                    return false;
                }
            }
        }
        return true;
    }
}
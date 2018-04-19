class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length, n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        LinkedList<Point> list = new LinkedList<>();
        list.offer(new Point(start[0], start[1]));
        while (!list.isEmpty()) {
            Point p = list.poll();
            int x = p.x, y = p.y;
            for (int[] dir : dirs) {
                int xx = x;
                int yy = y;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[0];
                    yy += dir[1];
                }
                xx -= dir[0];
                yy -= dir[1];
                if (visited[xx][yy]) {
                    continue;
                }
                visited[xx][yy] = true;
                if (xx == destination[0] && yy == destination[1]) {
                    return true;
                }
                list.offer(new Point(xx, yy));
            }
        }
        return false;
    }
}
class Point {
    int x,y;
    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
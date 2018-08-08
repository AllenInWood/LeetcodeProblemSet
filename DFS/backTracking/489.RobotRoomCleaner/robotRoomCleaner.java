/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtracking(robot, visited, 0, 0, 0);
    }
    private void backtracking(Robot robot, Set<String> visited, int i, int j, int curDir) {
        String tmp = i + "->" + j;
        if (visited.contains(tmp)) {
            return;
        }
        
        robot.clean();
        visited.add(tmp);
        
        for (int n = 0; n < 4; n++) {
            if (robot.move()) {
                int x = i, y = j;
                switch (curDir) {
                    case 0:
                        x = i - 1;
                        break;
                    case 90:
                        y = j + 1;
                        break;
                    case 180:
                        x = i + 1;
                        break;
                    case 270:
                        y = j - 1;
                        break;
                }
                backtracking(robot, visited, x, y, curDir);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            curDir += 90;
            curDir %= 360;
        }
    }
}
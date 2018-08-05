/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {   
    public List<Point> outerTrees(Point[] points) {
        if (points.length < 2) {
            return Arrays.asList(points);
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x == o2.x ? o2.y - o1.y : o2.x - o1.x;
            }
        });
        Stack<Point> hull = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (hull.size() >= 2 && calPolar(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) < 0) {
                hull.pop();
            }
            hull.push(points[i]);
        }
        hull.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() >= 2 && calPolar(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) < 0) {
                hull.pop();
            }
            hull.push(points[i]);
        }
        return new ArrayList<>(new HashSet<>(hull));
    }
    
    private int calPolar(Point a, Point b, Point r) {
        return (b.y - r.y) * (a.x - r.x) - (a.y - r.y) * (b.x - r.x);
    }
}
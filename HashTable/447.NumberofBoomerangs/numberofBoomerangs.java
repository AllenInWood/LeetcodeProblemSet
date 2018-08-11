class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0
            || points[0].length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                if (!map.containsKey(distance)) {
                    map.put(distance, 0);
                }
                map.put(distance, map.get(distance) + 1);
            }
            for (Integer key : map.keySet()) {
                int size = map.get(key);
                res += size * (size - 1);
            }
            map.clear();
        }
        return res;
    }
    
    private int getDistance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }
}
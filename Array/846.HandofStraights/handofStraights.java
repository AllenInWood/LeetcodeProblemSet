class Solution {
    // batch delete
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                int num = map.get(key);
                for (int i = 0; i < W; i++) {
                    if (map.getOrDefault(key + i, 0) < num) {
                        return false;
                    }
                    map.put(key + i, map.get(key + i) - num);
                }
            }
        }
        return true;
    }
}
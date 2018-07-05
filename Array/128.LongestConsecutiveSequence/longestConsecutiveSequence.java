class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            if (!map.containsKey(num - 1) && !map.containsKey(num + 1)) {
                map.put(num, 1);
            } else if (!map.containsKey(num - 1) && map.containsKey(num + 1)) {
                int r = map.get(num + 1);
                map.put(num, r + 1);
                map.put(num + r, r + 1);
            } else if (map.containsKey(num - 1) && !map.containsKey(num + 1)) {
                int l = map.get(num - 1);
                map.put(num, l + 1);
                map.put(num - l, l + 1);
            } else {
                int l = map.get(num - 1);
                int r = map.get(num + 1);
                map.put(num, l + r + 1);
                map.put(num - l, l + r + 1);
                map.put(num + r, l + r + 1);
            }
        }
        int max = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }
        return max;
    }
}
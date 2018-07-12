class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int ans = 0;
        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
            } else {
                while (i < map.get(s.charAt(j))) {
                    map.remove(s.charAt(i));
                    i++;
                }
                map.remove(s.charAt(i));
                i++;
                map.put(s.charAt(j), j);
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
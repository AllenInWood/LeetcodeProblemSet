class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
            } else {
                while (map.containsKey(s.charAt(j))) {
                    map.remove(s.charAt(i));
                    i++;
                }
                map.put(s.charAt(j), j);
            }
            maxLen = Math.max(maxLen, map.size());
            j++;
        }
        return maxLen;
    }
}
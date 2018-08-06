class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> values = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))
                && !values.contains(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                values.add(t.charAt(i));
            } else {
                if (map.containsKey(s.charAt(i))
                    && map.get(s.charAt(i)) == t.charAt(i)) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String s = words[i];
            if (map.containsKey(c)) {
                String s1 = map.get(c);
                if (!s1.equals(s)) {
                    return false;
                }
            } else {
                map.put(c, s);
            }
            if (reverseMap.containsKey(s)) {
                char c1 = reverseMap.get(s);
                if (c1 != c) {
                    return false;
                }
            } else {
                reverseMap.put(s, c);
            }
        }
        return true;
    }
}
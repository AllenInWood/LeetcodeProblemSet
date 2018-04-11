class Solution {
    // public boolean isAnagram(String s, String t) {
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char c : s.toCharArray()) {
    //         if (map.containsKey(c)) {
    //             map.put(c, map.get(c) + 1);
    //         } else {
    //             map.put(c, 1);
    //         }
    //     }
    //     for (char c : t.toCharArray()) {
    //         if (map.containsKey(c)) {
    //             if (map.get(c) == 0) {
    //                 return false;
    //             }
    //             map.put(c, map.get(c) - 1);
    //         } else {
    //             return false;
    //         }
    //     }
    //     for (Integer value : map.values()) {
    //         if (value > 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    // use array as map
    public boolean isAnagram(String s, String t) {
        if(s==null&&s==null){
        	return true;
        }
        if(s==null||t==null){
        	return false;
        }
        if(s.length()!=t.length()){
        	return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
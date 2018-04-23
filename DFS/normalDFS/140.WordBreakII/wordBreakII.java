class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        Map<String, List<String>> visited = new HashMap<>();
        return breaker(s, dict, visited);
    }
    private List<String> breaker(String s, Set<String> set, Map<String, List<String>> map) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (left.length() == 0 && set.contains(right)) {
                ans.add(right);
                continue;
            }
            if (set.contains(left)) {
                List<String> temp = breaker(right, set, map);
                if (temp.size() != 0) {
                    for (int j = 0; j < temp.size(); j++) {
                        ans.add(left + " " + temp.get(j));
                    }
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
}
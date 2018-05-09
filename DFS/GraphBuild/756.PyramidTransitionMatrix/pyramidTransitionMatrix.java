class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (allowed == null || allowed.size() == 0) {
            return false;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s.substring(2));
        }
        return dfs(bottom, map);
    }
    private boolean dfs(String bottom, Map<String, List<String>> map) {
        if (bottom.length() == 1) {
            return true;
        }
        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i + 2))) {
                return false;
            }
        }
        List<String> nexts = new ArrayList<>();
        getList(nexts, bottom, map, 0, new StringBuilder());
        for (String next : nexts) {
            if (dfs(next, map)) {
                return true;
            }
        }
        return false;
     }
    private void getList(List<String> nexts, String bottom,
                         Map<String, List<String>> map, int idx, StringBuilder sb) {
        if (idx == bottom.length() - 1) {
            nexts.add(sb.toString());
            return;
        }
        for (String s : map.get(bottom.substring(idx, idx + 2))) {
            sb.append(s);
            getList(nexts, bottom, map, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
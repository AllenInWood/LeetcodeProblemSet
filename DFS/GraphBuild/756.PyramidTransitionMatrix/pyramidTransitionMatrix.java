class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            if (!map.containsKey(s.substring(0, 2))) {
                map.put(s.substring(0, 2), new ArrayList<>());
            }
            map.get(s.substring(0, 2)).add(s.substring(2));
        }
        return dfs(bottom, map);
    }
    private boolean dfs(String bottom, Map<String, List<String>> map) {
        if (bottom.length() == 1) {
            return true;
        }
        List<String> nexts = new ArrayList<>();
        getNexts(map, nexts, bottom, new StringBuilder(), 0);
        for (String next : nexts) {
            if (dfs(next, map)) {
                return true;
            }
        }
        return false;
    }
    private void getNexts(Map<String, List<String>> map, List<String> nexts,
                          String bottom, StringBuilder sb, int idx) {
        if (idx == bottom.length() - 1) {
            nexts.add(sb.toString());
            return;
        }
        if (map.containsKey(bottom.substring(idx, idx + 2))) {
            for (String s : map.get(bottom.substring(idx, idx + 2))) {
                sb.append(s);
                getNexts(map, nexts, bottom, sb, idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
class Solution {
    public String crackSafe(int n, int k) {
        int total = (int) (Math.pow(k, n));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, visited, total, n, k);
        
        return sb.toString();
    }
    private boolean dfs(StringBuilder sb, Set<String> visited, int total, int n, int k) {
        if (visited.size() == total) {
            return true;
        }
        String cur = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++) {
            String next = cur + i;
            if (visited.contains(next)) {
                continue;
            }
            visited.add(next);
            sb.append(i);
            if (dfs(sb, visited, total, n, k)) {
                return true;
            } else {
                visited.remove(next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return ans;
        }
        // <node, neighbor nodes>
        Map<String, Set<String>> graph = new HashMap<>();
        // <email, belonging name>
        Map<String, String> name = new HashMap<>();
        
        // build  above maps
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                name.put(account.get(i), userName);
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                if (i == 1) {
                    continue;
                }
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        
        Set<String> visited = new HashSet<>();
        for (String email : name.keySet()) {
            List<String> list = new ArrayList<>();
            if (!visited.contains(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                ans.add(list);
            }
        }
        return ans;
    }
    
    private void dfs(Map<String, Set<String>> graph, String email,
                     Set<String> visited, List<String> list) {
        visited.add(email);
        list.add(email);
        for (String next : graph.get(email)) {
            if (!visited.contains(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }
}
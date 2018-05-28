class Solution {
    // public List<List<Integer>> getFactors(int n) {
    //     Set<List<Integer>> ans = new HashSet<>();
    //     if (n <= 3) {
    //         return new ArrayList<>(ans);
    //     }
    //     dfs(n, ans, new ArrayList<>(), 2);
    //     return new ArrayList<>(ans);
    // }
    // private void dfs(int n, Set<List<Integer>> ans, List<Integer> temp, int idx) {
    //     for (int i = idx; i <= Math.sqrt(n); i++) {
    //         if (n % i == 0 && n / i >= i) {
    //             temp.add(i);
    //             temp.add(n / i);
    //             ans.add(new ArrayList<>(temp));
    //             temp.remove(temp.size() - 1);
    //             dfs(n / i, ans, temp, i);
    //             temp.remove(temp.size() - 1);
    //         }
    //     }
    // }
    
    
    public List<List<Integer>> getFactors(int n) {
        Set<List<Integer>> ans = new HashSet<>();
        if (n <= 3) {
            return new ArrayList<>(ans);
        }
        dfs(n, ans, new ArrayList<>(), 2);
        return new ArrayList<>(ans);
    }
    private void dfs(int n, Set<List<Integer>> ans, List<Integer> temp, int idx) {
        if (n == 1) {
            if (temp.size() > 1) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = idx; i <= n; i++) {
            if (n % i == 0) {
                temp.add(i);
                dfs(n / i, ans, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
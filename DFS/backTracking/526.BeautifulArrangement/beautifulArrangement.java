class Solution {
    // number permutation
    // int count;
    // public int countArrangement(int N) {
    //     count = 0;
    //     int[] ans = new int[N];
    //     for (int i = 1; i <= N; i++) {
    //         ans[i - 1] = i;
    //     }
    //     permute(ans, 0);
    //     return count;
    // }
    // private void permute(int[] ans, int start) {
    //     if (start == ans.length) {
    //         count++;
    //         return;
    //     }
    //     for (int i = start; i < ans.length; i++) {
    //         swap(ans, i, start);
    //         if (ans[start] % (start + 1) == 0
    //             || (start + 1) % ans[start] == 0) {
    //             permute(ans, start + 1);
    //         }
    //         swap(ans, i, start);
    //     }
    // }
    // private void swap(int[] ans, int i, int j) {
    //     int temp = ans[i];
    //     ans[i] = ans[j];
    //     ans[j] = temp;
    // }
    
    
    // backtracking
    int count = 0;
    public int countArrangement(int N) {
        int[] visited = new int[N];
        Arrays.fill(visited, 0);
        int[] nums = new int[N];
        backtracking(nums, visited, 0);
        return count;
    }
    private void backtracking(int[] nums, int[] visited, int start) {
        if (start == nums.length) {
            count++;
            return;
        }
        for (int j = 0; j < visited.length; j++) {
            if (visited[j] == 0
                && ((j + 1) % (start + 1) == 0
                    || (start + 1) % (j + 1) == 0)) {
                visited[j] = 1;
                nums[start] = j + 1;
                backtracking(nums, visited, start + 1);
                nums[start] = 0;
                visited[j] = 0;
            }
        }
    }
}
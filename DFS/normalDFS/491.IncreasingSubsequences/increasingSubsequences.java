class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(ans);
        }
        findSet(ans, new ArrayList<>(), nums, 0);
        return new ArrayList<>(ans);
    }
    private void findSet(Set<List<Integer>> ans, List<Integer> temp, int[] nums, int index) {
        if (temp.size() > 1) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = index; i < nums.length; i++) {
            if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
                temp.add(nums[i]);
                findSet(ans, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
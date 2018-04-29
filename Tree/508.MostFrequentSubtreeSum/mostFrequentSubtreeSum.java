/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        addSum(root, map);
        int max = 0;
        for (Integer num : map.keySet()) {
            max = Math.max(max, map.get(num));
        }
        List<Integer> res = new ArrayList<Integer>();
        for (Integer num : map.keySet()) {
            if (map.get(num) == max) {
                res.add(num);
            }
        }
        int[] ans = new int[res.size()];
        int i = 0; 
        for (Integer l : res) {
            ans[i++] = l;
        }
        return ans;
    }
    private int addSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + addSum(root.left, map) + addSum(root.right, map);
        if (!map.containsKey(sum)) {
            map.put(sum, 0);
        }
        map.put(sum, map.get(sum) + 1);
        return sum;
    }
}
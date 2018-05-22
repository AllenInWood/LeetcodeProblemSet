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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        while (root != null) {
            List<Integer> temp = new ArrayList<>();
            if (dfs(temp, root)) {
                root = null;
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
    // return if current node is leaf
    private boolean dfs(List<Integer> temp, TreeNode root) {
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            return true;
        }
        if (root.left != null) {
            if (dfs(temp, root.left)) {
                root.left = null;
            }
        }
        if (root.right != null) {
            if (dfs(temp, root.right)) {
                root.right = null;
            }
        }
        return false;
    }
}
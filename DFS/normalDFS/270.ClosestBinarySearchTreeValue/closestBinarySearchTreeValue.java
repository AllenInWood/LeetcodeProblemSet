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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        
        double[] ans = new double[1];
        ans[0] = Double.MAX_VALUE;
        dfs(root, target, ans);
        
        return (int) ans[0];
    }
    private void dfs(TreeNode root, double target, double[] ans) {
        if (root == null) {
            return;
        }
        ans[0] = Math.abs(root.val - target)
            < Math.abs(ans[0] - target)
            ? root.val : ans[0];
        dfs(root.left, target, ans);
        dfs(root.right, target, ans);
    }
}
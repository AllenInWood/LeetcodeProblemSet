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
    int max;
    public int sumNumbers(TreeNode root) {
        max = 0;
        if (root == null) {
            return max;
        }
        dfs(root, 0);
        return max;
    }
    private void dfs(TreeNode root, int tempAmount) {
        if (root.left == null && root.right == null) {
            max += tempAmount + root.val;
            return;
        }
        if (root.left != null) {
            dfs(root.left, (tempAmount + root.val) * 10);
        }
        if (root.right != null) {
            dfs(root.right, (tempAmount + root.val) * 10);
        }
    }
}
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
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        if (root == null) {
            return sum;
        }
        dfs(root);
        return sum;
    }
    private boolean dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            if (dfs(root.left)) {
                sum += root.left.val;
            }
        }
        if (root.right != null) {
            dfs(root.right);
        }
        return false;
    }
}
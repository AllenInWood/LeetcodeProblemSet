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
    int min;
    int secondMin;
    public int findSecondMinimumValue(TreeNode root) {
        min = Integer.MAX_VALUE;
        dfs(root);
        return secondMin == Integer.MAX_VALUE ? -1 : secondMin;
    }
    private void dfs(TreeNode root) {
        if (root.val < min) {
            secondMin = min;
            min = root.val;
        } else if (root.val > min && root.val < secondMin) {
            secondMin = root.val;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
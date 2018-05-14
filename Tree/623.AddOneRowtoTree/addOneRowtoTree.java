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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        List<TreeNode> targetDepthNode = new ArrayList<>();
        dfs(root, targetDepthNode, d, 1);
        for (TreeNode target : targetDepthNode) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = target.left;
            target.left = left;
            right.right = target.right;
            target.right = right;
        }
        return root;
    }
    private void dfs(TreeNode root, List<TreeNode> returnList, int d, int curDepth) {
        if (curDepth == d - 1) {
            returnList.add(root);
        }
        if (root.left != null) {
            dfs(root.left, returnList, d, curDepth + 1);
        }
        if (root.right != null) {
            dfs(root.right, returnList, d, curDepth + 1);
        }
    }
}
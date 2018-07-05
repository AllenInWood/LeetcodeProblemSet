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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return bfs(root);
    }
    private int bfs(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() != 0) {
            List<TreeNode> next = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                TreeNode cur = list.get(i);
                if (cur.left != null) {
                    next.add(cur.left);
                }
                if (cur.right != null) {
                    next.add(cur.right);
                }
            }
            if (next.size() == 0) {
                break;
            }
            list = next;
        }
        return list.get(0).val;
    }
}
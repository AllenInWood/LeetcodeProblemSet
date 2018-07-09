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
    // public int rob(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int value = 0;
    //     if (root.left != null) {
    //         value += rob(root.left.left) + rob(root.left.right);
    //     }
    //     if (root.right != null) {
    //         value += rob(root.right.left) + rob(root.right.right);
    //     }
    //     return Math.max(value + root.val, rob(root.left) + rob(root.right));
    // }
    
    
    
    // hash map stores calculated value
    // public int rob(TreeNode root) {
    //     return robHelper(root, new HashMap<>());
    // }
    // private int robHelper(TreeNode root, Map<TreeNode, Integer> hash) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     if (hash.containsKey(root)) {
    //         return hash.get(root);
    //     }
    //     int value = 0;
    //     if (root.left != null) {
    //         value += robHelper(root.left.left, hash) + robHelper(root.left.right, hash);
    //     }
    //     if (root.right != null) {
    //         value += robHelper(root.right.left, hash) + robHelper(root.right.right, hash);
    //     }
    //     int res = Math.max(root.val + value, robHelper(root.left, hash) + robHelper(root.right, hash));
    //     hash.put(root, res);
    //     return res;
    // }
    
    
    
    // return an array
    // the first element of which denotes the maximum amount of money that can be robbed if root is not robbed,
    // the second element signifies the maximum amount of money robbed if it is robbed
    public int rob(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }
    private int[] robHelper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
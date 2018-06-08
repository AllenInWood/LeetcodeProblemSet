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
    // recursive traverse
    // int preSum;
    // public TreeNode convertBST(TreeNode root) {
    //     preSum = 0;
    //     traverse(root);
    //     return root;
    // }
    // private void traverse(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     traverse(root.right);
    //     int temp = root.val;
    //     root.val += preSum;
    //     preSum += temp;
    //     traverse(root.left);
    // }
    
    
    //iterative traverse
    // public TreeNode convertBST(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     int sum = 0;
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode cur = root;
    //     while (!stack.isEmpty() || cur != null) {
    //         while (cur != null) {
    //             stack.push(cur);
    //             cur = cur.right;
    //         }
    //         cur = stack.pop();
    //         int temp = cur.val;
    //         cur.val += sum;
    //         sum += temp;
    //         cur = cur.left;
    //     }
    //     return root;
    // }
    
    
    // no stack traverse, traverse in-order
    public TreeNode convertBST(TreeNode root) {
        TreeNode cur = root;
        int sum = 0;
        while (cur != null) {
            if (cur.right == null) {
                int tmp = cur.val;
                cur.val += sum;
                sum += tmp;
                cur = cur.left;
            } else {
                TreeNode pre = cur.right;
                while (pre.left != null && pre.left != cur) {
                    pre = pre.left;
                }
                if (pre.left == null) {
                    pre.left = cur;
                    cur = cur.right;
                } else {
                    pre.left = null;
                    int tmp = cur.val;
                    cur.val += sum;
                    sum += tmp;
                    cur = cur.left;
                }
            }
        }
        return root;
    }
}
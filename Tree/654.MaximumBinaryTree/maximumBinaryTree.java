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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructTree(nums, 0, nums.length - 1);
    }
    private TreeNode constructTree(int[] nums, int i, int j) {
        maxCombo mc = findMaxValue(nums, i, j);
        TreeNode root = new TreeNode(mc.value);
        if (mc.index > i) {
            root.left = constructTree(nums, i, mc.index - 1);
        }
        if (mc.index < j) {
            root.right = constructTree(nums, mc.index + 1, j);
        }
        return root;
    }
    private maxCombo findMaxValue(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int k = i; k <= j; k++) {
            if (nums[k] > max) {
                max = nums[k];
                index = k;
            }
        }
        return new maxCombo(max, index);
    }
}
class maxCombo {
    int value;
    int index;
    maxCombo(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
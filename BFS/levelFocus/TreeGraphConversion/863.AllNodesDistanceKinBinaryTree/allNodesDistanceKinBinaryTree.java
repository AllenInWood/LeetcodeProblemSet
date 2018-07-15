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
    // Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    // public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null || K < 0) {
    //         return res;
    //     }
    //     buildMap(root, null);
    //     if (!map.containsKey(target)) {
    //         return res;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     Set<TreeNode> visited = new HashSet<>();
    //     queue.offer(target);
    //     visited.add(target);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         if (K == 0) {
    //             for (int i = 0; i < size; i++) {
    //                 res.add(queue.poll().val);
    //             }
    //             return res;
    //         }
    //         for (int i = 0; i < size; i++) {
    //             TreeNode cur = queue.poll();
    //             for (TreeNode neighbor : map.get(cur)) {
    //                 if (!visited.contains(neighbor)) {
    //                     queue.offer(neighbor);
    //                     visited.add(neighbor);
    //                 }
    //             }
    //         }
    //         K--;
    //     }
    //     return res;
    // }
    // private void buildMap(TreeNode node, TreeNode parent) {
    //     if (node == null) {
    //         return;
    //     }
    //     if (!map.containsKey(node)) {
    //         map.put(node, new ArrayList<>());
    //         if (parent != null) {
    //             map.get(node).add(parent);
    //             map.get(parent).add(node);
    //         }
    //         buildMap(node.left, node);
    //         buildMap(node.right, node);
    //     }
    // }
    
    
    private GNode targetGNode;
    
    private class GNode {
        TreeNode node;
        GNode parent, left, right;
        GNode(TreeNode node) {
            this.node = node;
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null || K < 0) {
            return res;
        }
        cloneGraph(root, null, target);
        if (targetGNode == null) {
            return res;
        }
        Queue<GNode> queue = new LinkedList<>();
        Set<GNode> visited = new HashSet<>();
        queue.offer(targetGNode);
        visited.add(targetGNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                while (size-- > 0) {
                    res.add(queue.poll().node.val);
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                GNode cur = queue.poll();
                if (cur.parent != null
                    && !visited.contains(cur.parent)) {
                    queue.offer(cur.parent);
                    visited.add(cur.parent);
                }
                if (cur.left != null
                    && !visited.contains(cur.left)) {
                    queue.offer(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null
                    && !visited.contains(cur.right)) {
                    queue.offer(cur.right);
                    visited.add(cur.right);
                }
            }
            K--;
        }
        return res;
    }
    private GNode cloneGraph(TreeNode node, GNode parent, TreeNode target) {
        if (node == null) {
            return null;
        }
        GNode gNode = new GNode(node);
        if (node == target) {
            targetGNode = gNode;
        }
        gNode.parent = parent;
        gNode.left = cloneGraph(node.left, gNode, target);
        gNode.right = cloneGraph(node.right, gNode, target);
        return gNode;
    }
}
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new TreeMap<>(
            new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }
        );
        bfs(root, map, 0);
        List<List<Integer>> ans = new ArrayList<>(map.values());
        return ans;
    }
    // disordered
    private void dfs(TreeNode root, Map<Integer, List<Integer>> map, int index) {
        List<Integer> cur = map.containsKey(index)
            ? map.get(index) : new ArrayList<>();
        cur.add(root.val);
        map.put(index, cur);
        if (root.left != null) {
            dfs(root.left, map, index - 1);
        }
        if (root.right != null) {
            dfs(root.right, map, index + 1);
        }
    }
    private void bfs(TreeNode root, Map<Integer, List<Integer>> map, int index) {
        Queue<TreeInfo> queue = new LinkedList<>();
        TreeInfo ti = new TreeInfo(root, index);
        queue.offer(ti);
        while (!queue.isEmpty()) {
            TreeInfo temp = queue.poll();
            List<Integer> cur = map.containsKey(temp.index)
                ? map.get(temp.index) : new ArrayList<>();
            cur.add(temp.node.val);
            map.put(temp.index, cur);
            
            if (temp.node.left != null) {
                TreeInfo left = new TreeInfo(temp.node.left,
                                             temp.index - 1);
                queue.offer(left);
            }
            if (temp.node.right != null) {
                TreeInfo right = new TreeInfo(temp.node.right,
                                             temp.index + 1);
                queue.offer(right);
            }
        }
    }
}

class TreeInfo {
    TreeNode node;
    int index;
    public TreeInfo(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
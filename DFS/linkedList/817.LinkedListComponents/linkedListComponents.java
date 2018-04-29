/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public int numComponents(ListNode head, int[] G) {
    //     if (head == null) {
    //         return G.length;
    //     }
    //     Map<Integer, ListNode> map = new HashMap<>();
    //     ListNode cur = head;
    //     while (cur != null) {
    //         map.put(cur.val, cur);
    //         cur = cur.next;
    //     }
    //     Set<Integer> set = new HashSet<>();
    //     for (int num : G) {
    //         set.add(num);
    //     }
    //     int res = G.length;
    //     for (int num : G) {
    //         ListNode node = map.get(num);
    //         if (node.next != null
    //             && set.contains(node.next.val)) {
    //             res--;
    //         }
    //     }
    //     return res;
    // }
    
    
    //dfs
    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null || G.length == 0) {
            return 0;
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int ans = 0;
        while (head != null) {
            if (set.contains(head.val)
                && !visited.contains(head.val)) {
                ans++;
                dfs(head, visited, set);
            }
            head = head.next;
        }
        return ans;
    }
    private void dfs(ListNode node,
                        Set<Integer> visited,
                        Set<Integer> set) {
        visited.add(node.val);
        if (node.next != null
            && !visited.contains(node.next.val)
            && set.contains(node.next.val)) {
            dfs(node.next, visited, set);
        }
    }
}
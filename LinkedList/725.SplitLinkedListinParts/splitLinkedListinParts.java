/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode temp = root;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        ListNode[] res = new ListNode[k];
        int size = count / k;
        int left = count % k;
        for (int i = 0; i < k; i++) {
            ListNode ans = root;
            int j = size;
            while (root != null && j > 1) {
                root = root.next;
                j--;
            }
            if (size != 0 && left > 0 && root != null) {
                root = root.next;
                left--;
            }
            ListNode tail = root;
            if (root != null) {
                root = root.next;
            }
            if (tail != null) {
                tail.next = null;
            }
            res[i] = ans;
        }
        return res;
    }
}
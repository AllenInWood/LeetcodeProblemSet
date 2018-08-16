/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = dummyNode;
        int len = n - m + 1;
        while (m != 1) {
            pre = pre.next;
            cur = cur.next;
            m--;
        }
        cur = cur.next;
        ListNode curCopy = cur;
        ListNode preCopy = pre;
        ListNode next;
        while (cur != null && len != 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            len--;
        }
        preCopy.next = pre;
        curCopy.next = cur;
        return dummyNode.next;
    }
}
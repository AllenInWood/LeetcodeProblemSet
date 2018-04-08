/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy, prev = dummy, post;
        int count;
        while (true) {
            count  = k;
            while (count > 0 && tail != null) {
                tail = tail.next;
                count--;
            }
            if (tail == null) {
                break;
            }
            head = prev.next;
            while (prev.next != tail) {
                post = prev.next;
                prev.next = post.next;
                post.next = tail.next;
                tail.next = post;
            }
            tail = head;
            prev = head;
        }
        return dummy.next;
    }
}
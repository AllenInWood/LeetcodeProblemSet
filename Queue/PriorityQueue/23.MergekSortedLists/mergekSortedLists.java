/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val < o2.val) {
                        return -1;
                    } else if (o1.val == o2.val) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        );
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        
        return dummy.next;
    }
}
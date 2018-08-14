/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        flattenNode(head);
        return head;
    }
    private Node flattenNode(Node head) {
        if (head == null) {
            return head;
        } else if (head.child == null) {
            if (head.next == null) {
                return head;
            }
            return flattenNode(head.next);
        } else {
            Node child = head.child;
            head.child = null;
            Node next = head.next;
            Node childTail = flattenNode(child);
            head.next = child;
            child.prev = head;
            if (next != null) {
                childTail.next = next;
                next.prev = childTail;
                return flattenNode(next);
            }
            return childTail;
        }
    }
}
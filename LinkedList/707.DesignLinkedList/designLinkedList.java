class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
    }
    
    private ListNode head;
    private ListNode tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode();
        tail = new ListNode();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        } else {
            ListNode temp = head;
            while (index >= 0) {
                temp = temp.next;
                index--;
            }
            return temp.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode();
        node.val = val;
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode();
        node.val = val;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else if (index == size) {
            addAtTail(val);
        } else {
            ListNode temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            ListNode node = new ListNode();
            node.val = val;
            temp.next.prev = node;
            node.next = temp.next;
            temp.next = node;
            node.prev = temp;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        } else {
            ListNode temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            ListNode next = temp.next.next;
            next.prev = temp;
            temp.next = next;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
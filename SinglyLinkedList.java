/** Singly linked list of ints with step counting. */
public class SinglyLinkedList {
    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;
    private int size;
    private long lastSteps;

    public int size() { return size; }
    public boolean isEmpty() { return head == null; }
    public long getLastSteps() { return lastSteps; }

    /** Insert at head. O(1). */
    public void insertAtHead(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
        size++;
        lastSteps = 1;
    }

    /** Insert at tail. O(n) because there is no tail pointer. */
    public void insertAtTail(int value) {
        Node n = new Node(value);
        lastSteps = 0;
        if (head == null) {
            head = n;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
                lastSteps++;
            }
            cur.next = n;
        }
        size++;
        lastSteps++;
    }

    /** Insert at position (0..size). */
    public boolean insertAt(int index, int value) {
        if (index < 0 || index > size) return false;
        if (index == 0) { insertAtHead(value); return true; }
        lastSteps = 0;
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
            lastSteps++;
        }
        Node n = new Node(value);
        n.next = cur.next;
        cur.next = n;
        size++;
        lastSteps++;
        return true;
    }

    /** Delete first node with the given value. Returns true if removed. */
    public boolean delete(int value) {
        lastSteps = 0;
        if (head == null) return false;
        if (head.value == value) {
            head = head.next;
            size--;
            lastSteps = 1;
            return true;
        }
        Node cur = head;
        lastSteps = 1;
        while (cur.next != null) {
            lastSteps++;
            if (cur.next.value == value) {
                cur.next = cur.next.next;
                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /** Returns 0-based position of value or -1. */
    public int search(int value) {
        lastSteps = 0;
        Node cur = head;
        int idx = 0;
        while (cur != null) {
            lastSteps++;
            if (cur.value == value) return idx;
            cur = cur.next;
            idx++;
        }
        return -1;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("HEAD -> ");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.value).append(" -> ");
        }
        sb.append("NULL  (size " + size + ")");
        System.out.println(sb);
    }
}

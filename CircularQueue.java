/** Circular array-backed FIFO queue. All main operations are O(1). */
public class CircularQueue {
    private final int[] items;
    private int front = 0;
    private int count = 0;

    public CircularQueue(int capacity) { items = new int[capacity]; }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == items.length; }
    public int size() { return count; }

    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("Queue overflow: queue is full.");
        items[(front + count) % items.length] = value;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue underflow: cannot dequeue from an empty queue.");
        int v = items[front];
        front = (front + 1) % items.length;
        count--;
        return v;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty: nothing at the front.");
        return items[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Front -> ");
        for (int i = 0; i < count; i++) {
            sb.append(items[(front + i) % items.length]);
            if (i < count - 1) sb.append(" | ");
        }
        sb.append(" <- Rear");
        System.out.println(sb);
    }
}

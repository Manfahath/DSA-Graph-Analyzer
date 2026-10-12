/**
 * Fixed-capacity array of ints with explicit size tracking.
 * Counts element shifts/comparisons so operations can be compared.
 */
public class DynamicArray {
    private final int[] data;
    private int size;
    private long lastSteps;   // steps used by the most recent operation

    public DynamicArray(int capacity) {
        data = new int[capacity];
    }

    public int size() { return size; }
    public int capacity() { return data.length; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }
    public long getLastSteps() { return lastSteps; }

    /** Insert value at index (0..size), shifting later elements right. O(n). */
    public boolean insert(int index, int value) {
        lastSteps = 0;
        if (isFull() || index < 0 || index > size) return false;
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
            lastSteps++;
        }
        data[index] = value;
        size++;
        lastSteps++;
        return true;
    }

    /** Append at the end. O(1). */
    public boolean append(int value) { return insert(size, value); }

    /** Delete element at index, shifting later elements left. O(n). */
    public boolean deleteAt(int index) {
        lastSteps = 0;
        if (index < 0 || index >= size) return false;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            lastSteps++;
        }
        size--;
        lastSteps++;
        return true;
    }

    /** Linear search; returns index or -1. */
    public int search(int key) {
        lastSteps = 0;
        for (int i = 0; i < size; i++) {
            lastSteps++;
            if (data[i] == key) return i;
        }
        return -1;
    }

    public int get(int index) { return data[index]; }

    /** Returns a copy of the used portion. */
    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    /** Replaces contents with the given values (up to capacity). */
    public void load(int[] values) {
        size = 0;
        for (int v : values) {
            if (size == data.length) break;
            data[size++] = v;
        }
    }

    public void clear() { size = 0; }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]  (size " + size + "/" + data.length + ")");
        System.out.println(sb);
    }
}

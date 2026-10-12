/** Linear and binary search implementations that count comparisons and time. */
public class Searching {

    /** Outcome of a search. */
    public static class Result {
        public final int index;
        public final long steps;
        public final long nanos;
        public Result(int index, long steps, long nanos) {
            this.index = index;
            this.steps = steps;
            this.nanos = nanos;
        }
    }

    /** O(n): checks each element in turn. */
    public static Result linear(int[] a, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int found = -1;
        for (int i = 0; i < a.length; i++) {
            steps++;
            if (a[i] == key) { found = i; break; }
        }
        return new Result(found, steps, System.nanoTime() - start);
    }

    /** O(log n): requires a sorted array. */
    public static Result binary(int[] a, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int lo = 0, hi = a.length - 1, found = -1;
        while (lo <= hi) {
            steps++;
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) { found = mid; break; }
            if (a[mid] < key) lo = mid + 1; else hi = mid - 1;
        }
        return new Result(found, steps, System.nanoTime() - start);
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    /** Simple insertion sort so the project does not rely on library sorting. */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}

import java.util.Random;

/** Benchmarks searching, graph traversal and insertion costs. */
public class PerformanceAnalyzer {

    public static void run() {
        int[] sizes = {1000, 10000, 100000};
        Random rnd = new Random(42);

        System.out.println("=============================================");
        System.out.println("PERFORMANCE COMPARISON");
        System.out.println("=============================================");

        // ---- Searching (worst case: key is the last element) ----
        System.out.printf("%-14s %-16s %-10s %-12s %-10s%n", "Operation", "Algorithm", "N", "Steps", "Time(ns)");
        System.out.println("---------------------------------------------------------------");
        for (int n : sizes) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = i * 2;          // already sorted
            int key = a[n - 1];                                  // worst case for linear
            Searching.Result lin = Searching.linear(a, key);
            Searching.Result bin = Searching.binary(a, key);
            System.out.printf("%-14s %-16s %-10d %-12d %-10d%n", "Search", "Linear Search", n, lin.steps, lin.nanos);
            System.out.printf("%-14s %-16s %-10d %-12d %-10d%n", "Search", "Binary Search", n, bin.steps, bin.nanos);
            ResultLog.add("Performance: N=" + n + " Linear steps=" + lin.steps + ", Binary steps=" + bin.steps);
        }

        // ---- Graph traversal ----
        System.out.println("---------------------------------------------------------------");
        for (int v : new int[]{100, 1000, 5000}) {
            Graph g = Graph.randomConnected(v, v * 2, rnd.nextLong());
            Graph.Traversal b = g.bfs(0);
            Graph.Traversal d = g.dfs(0);
            System.out.printf("%-14s %-16s V=%-8d %-12d %-10d%n", "Graph Traversal", "BFS", v, b.steps, b.nanos);
            System.out.printf("%-14s %-16s V=%-8d %-12d %-10d%n", "Graph Traversal", "DFS", v, d.steps, d.nanos);
            ResultLog.add("Performance: V=" + v + " E=" + g.edgeCount() + " BFS steps=" + b.steps + ", DFS steps=" + d.steps);
        }

        // ---- Insertion at the front: array shifts vs linked-list head insert ----
        System.out.println("---------------------------------------------------------------");
        for (int n : new int[]{1000, 10000}) {
            DynamicArray arr = new DynamicArray(n);
            long arrSteps = 0;
            for (int i = 0; i < n; i++) {
                arr.insert(0, i);
                arrSteps += arr.getLastSteps();
            }
            SinglyLinkedList list = new SinglyLinkedList();
            long listSteps = 0;
            for (int i = 0; i < n; i++) {
                list.insertAtHead(i);
                listSteps += list.getLastSteps();
            }
            System.out.printf("%-14s %-16s N=%-8d %-12d%n", "Insert front", "Array", n, arrSteps);
            System.out.printf("%-14s %-16s N=%-8d %-12d%n", "Insert front", "Linked List", n, listSteps);
            ResultLog.add("Performance: " + n + " front inserts Array steps=" + arrSteps + ", LinkedList steps=" + listSteps);
        }
        System.out.println("=============================================");
        System.out.println("Linear search is O(n) while binary search is O(log n); BFS/DFS are both O(V+E),");
        System.out.println("so their step counts are similar. Array front-insert is O(n) per insert (shifting)");
        System.out.println("whereas linked-list head insert is O(1).");
    }
}

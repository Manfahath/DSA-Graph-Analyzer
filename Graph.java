import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Undirected, unweighted graph stored as an adjacency list.
 * Vertices are integer ids. BFS and DFS return the visit order and the
 * number of steps (vertices dequeued/popped + edges examined).
 */
public class Graph {
    private final Map<Integer, List<Integer>> adj = new LinkedHashMap<>();
    private int edgeCount;

    /** Result of a traversal. */
    public static class Traversal {
        public final List<Integer> order = new ArrayList<>();
        public long steps;
        public long nanos;
    }

    public int vertexCount() { return adj.size(); }
    public int edgeCount() { return edgeCount; }
    public boolean hasVertex(int v) { return adj.containsKey(v); }
    public boolean isEmpty() { return adj.isEmpty(); }

    public boolean hasEdge(int a, int b) {
        return adj.containsKey(a) && adj.get(a).contains(b);
    }

    /** Adds a vertex. Returns false if it already exists. */
    public boolean addVertex(int v) {
        if (adj.containsKey(v)) return false;
        adj.put(v, new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge. Returns an error message, or null on success. */
    public String addEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b)) return "Both vertices must exist first.";
        if (a == b) return "Self-loops are not allowed.";
        if (hasEdge(a, b)) return "Edge already exists.";
        adj.get(a).add(b);
        adj.get(b).add(a);
        edgeCount++;
        return null;
    }

    public void display() {
        if (adj.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Adjacency list (" + vertexCount() + " vertices, " + edgeCount + " edges):");
        for (Map.Entry<Integer, List<Integer>> e : adj.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    /** Breadth-first search using a queue. O(V + E). */
    public Traversal bfs(int start) {
        Traversal t = new Traversal();
        long begin = System.nanoTime();
        Map<Integer, Boolean> visited = new java.util.HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        visited.put(start, true);
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            t.steps++;
            t.order.add(v);
            for (int n : adj.get(v)) {
                t.steps++;
                if (!visited.containsKey(n)) {
                    visited.put(n, true);
                    q.add(n);
                }
            }
        }
        t.nanos = System.nanoTime() - begin;
        return t;
    }

    /** Depth-first search using an explicit stack. O(V + E). */
    public Traversal dfs(int start) {
        Traversal t = new Traversal();
        long begin = System.nanoTime();
        Map<Integer, Boolean> visited = new java.util.HashMap<>();
        java.util.Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (visited.containsKey(v)) continue;
            visited.put(v, true);
            t.steps++;
            t.order.add(v);
            List<Integer> nbrs = adj.get(v);
            // push in reverse so the first neighbour is explored first
            for (int i = nbrs.size() - 1; i >= 0; i--) {
                t.steps++;
                if (!visited.containsKey(nbrs.get(i))) stack.push(nbrs.get(i));
            }
        }
        t.nanos = System.nanoTime() - begin;
        return t;
    }

    /** Builds a connected random graph for benchmarking. */
    public static Graph randomConnected(int vertices, int extraEdges, long seed) {
        Graph g = new Graph();
        java.util.Random r = new java.util.Random(seed);
        for (int i = 0; i < vertices; i++) g.addVertex(i);
        for (int i = 1; i < vertices; i++) g.addEdge(i, r.nextInt(i));   // spanning tree
        for (int i = 0; i < extraEdges; i++) g.addEdge(r.nextInt(vertices), r.nextInt(vertices));
        return g;
    }
}

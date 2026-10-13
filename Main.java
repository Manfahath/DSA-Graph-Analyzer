import java.util.List;
import java.util.Random;

/** Entry point: main menu and all component submenus. */
public class Main {

    private static DynamicArray array = new DynamicArray(50);
    private static ArrayStack stack = new ArrayStack(10);
    private static CircularQueue queue = new CircularQueue(10);
    private static SinglyLinkedList list = new SinglyLinkedList();
    private static Graph graph = new Graph();

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("=============================================");
            System.out.println("DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            switch (InputHelper.readChoice(1, 9)) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: listMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7: PerformanceAnalyzer.run(); break;
                case 8: ResultLog.displayAll(); break;
                case 9: System.out.println("Goodbye!"); return;
            }
        }
    }

    // ---------------- ARRAY ----------------
    private static void arrayMenu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at position");
            System.out.println("2. Append to end");
            System.out.println("3. Delete at position");
            System.out.println("4. Search for value");
            System.out.println("5. Display array");
            System.out.println("6. Return to Main Menu");
            switch (InputHelper.readChoice(1, 6)) {
                case 1: {
                    if (array.isFull()) { System.out.println("Array is full."); break; }
                    int idx = InputHelper.readInt("Position (0.." + array.size() + "): ");
                    int val = InputHelper.readInt("Value: ");
                    if (array.insert(idx, val)) {
                        System.out.println("Inserted. Steps: " + array.getLastSteps());
                        ResultLog.add("Array insert " + val + " at " + idx + " (steps " + array.getLastSteps() + ")");
                    } else System.out.println("Invalid position.");
                    break;
                }
                case 2: {
                    if (array.isFull()) { System.out.println("Array is full."); break; }
                    int val = InputHelper.readInt("Value: ");
                    array.append(val);
                    System.out.println("Appended.");
                    ResultLog.add("Array append " + val);
                    break;
                }
                case 3: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int idx = InputHelper.readInt("Position (0.." + (array.size() - 1) + "): ");
                    if (array.deleteAt(idx)) {
                        System.out.println("Deleted. Steps: " + array.getLastSteps());
                        ResultLog.add("Array delete at " + idx + " (steps " + array.getLastSteps() + ")");
                    } else System.out.println("Invalid position.");
                    break;
                }
                case 4: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int key = InputHelper.readInt("Value to search: ");
                    int pos = array.search(key);
                    String msg = pos >= 0 ? "Found at index " + pos : "Not found";
                    System.out.println(msg + ". Steps: " + array.getLastSteps());
                    ResultLog.add("Array search " + key + ": " + msg + " (steps " + array.getLastSteps() + ")");
                    break;
                }
                case 5: array.display(); break;
                case 6: return;
            }
        }
    }

    // ---------------- STACK ----------------
    private static void stackMenu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            try {
                switch (InputHelper.readChoice(1, 5)) {
                    case 1: {
                        int v = InputHelper.readInt("Value to push: ");
                        stack.push(v);
                        System.out.println("Pushed " + v);
                        ResultLog.add("Stack push " + v);
                        break;
                    }
                    case 2: {
                        int v = stack.pop();
                        System.out.println("Popped " + v);
                        ResultLog.add("Stack pop " + v);
                        break;
                    }
                    case 3: System.out.println("Top element: " + stack.peek()); break;
                    case 4: stack.display(); break;
                    case 5: return;
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ---------------- QUEUE ----------------
    private static void queueMenu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek/Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            try {
                switch (InputHelper.readChoice(1, 5)) {
                    case 1: {
                        int v = InputHelper.readInt("Value to enqueue: ");
                        queue.enqueue(v);
                        System.out.println("Enqueued " + v);
                        ResultLog.add("Queue enqueue " + v);
                        break;
                    }
                    case 2: {
                        int v = queue.dequeue();
                        System.out.println("Dequeued " + v);
                        ResultLog.add("Queue dequeue " + v);
                        break;
                    }
                    case 3: System.out.println("Front element: " + queue.peek()); break;
                    case 4: queue.display(); break;
                    case 5: return;
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ---------------- LINKED LIST ----------------
    private static void listMenu() {
        while (true) {
            System.out.println("\n------------ LINKED LIST OPERATIONS ------------");
            System.out.println("1. Insert at head");
            System.out.println("2. Insert at tail");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete by value");
            System.out.println("5. Search for value");
            System.out.println("6. Display list");
            System.out.println("7. Return to Main Menu");
            switch (InputHelper.readChoice(1, 7)) {
                case 1: {
                    int v = InputHelper.readInt("Value: ");
                    list.insertAtHead(v);
                    System.out.println("Inserted at head. Steps: " + list.getLastSteps());
                    ResultLog.add("List insert head " + v);
                    break;
                }
                case 2: {
                    int v = InputHelper.readInt("Value: ");
                    list.insertAtTail(v);
                    System.out.println("Inserted at tail. Steps: " + list.getLastSteps());
                    ResultLog.add("List insert tail " + v + " (steps " + list.getLastSteps() + ")");
                    break;
                }
                case 3: {
                    int idx = InputHelper.readInt("Position (0.." + list.size() + "): ");
                    int v = InputHelper.readInt("Value: ");
                    if (list.insertAt(idx, v)) {
                        System.out.println("Inserted. Steps: " + list.getLastSteps());
                        ResultLog.add("List insert " + v + " at " + idx);
                    } else System.out.println("Invalid position.");
                    break;
                }
                case 4: {
                    if (list.isEmpty()) { System.out.println("List is empty."); break; }
                    int v = InputHelper.readInt("Value to delete: ");
                    boolean ok = list.delete(v);
                    System.out.println((ok ? "Deleted " + v : v + " not found") + ". Steps: " + list.getLastSteps());
                    ResultLog.add("List delete " + v + ": " + (ok ? "deleted" : "not found"));
                    break;
                }
                case 5: {
                    if (list.isEmpty()) { System.out.println("List is empty."); break; }
                    int v = InputHelper.readInt("Value to search: ");
                    int pos = list.search(v);
                    String msg = pos >= 0 ? "Found at position " + pos : "Not found";
                    System.out.println(msg + ". Steps: " + list.getLastSteps());
                    ResultLog.add("List search " + v + ": " + msg + " (steps " + list.getLastSteps() + ")");
                    break;
                }
                case 6: list.display(); break;
                case 7: return;
            }
        }
    }

    // ---------------- SEARCHING ----------------
    private static void searchMenu() {
        while (true) {
            System.out.println("\n-------------- SEARCHING OPERATIONS --------------");
            System.out.println("1. Generate random sorted data (uses the Array component)");
            System.out.println("2. Sort current array data");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Compare Linear vs Binary");
            System.out.println("6. Display array");
            System.out.println("7. Return to Main Menu");
            switch (InputHelper.readChoice(1, 7)) {
                case 1: {
                    int n = InputHelper.readInt("How many elements (1.." + array.capacity() + "): ", 1, array.capacity());
                    Random r = new Random();
                    int[] data = new int[n];
                    for (int i = 0; i < n; i++) data[i] = r.nextInt(1000);
                    Searching.insertionSort(data);
                    array.load(data);
                    System.out.println("Generated " + n + " sorted values.");
                    array.display();
                    break;
                }
                case 2: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int[] data = array.toArray();
                    Searching.insertionSort(data);
                    array.load(data);
                    System.out.println("Array sorted.");
                    array.display();
                    break;
                }
                case 3: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int key = InputHelper.readInt("Value to search: ");
                    Searching.Result r = Searching.linear(array.toArray(), key);
                    printSearch("Linear", key, r);
                    break;
                }
                case 4: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int[] data = array.toArray();
                    if (!Searching.isSorted(data)) {
                        System.out.println("Binary search needs sorted data. Use option 2 first.");
                        break;
                    }
                    int key = InputHelper.readInt("Value to search: ");
                    printSearch("Binary", key, Searching.binary(data, key));
                    break;
                }
                case 5: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int[] data = array.toArray();
                    if (!Searching.isSorted(data)) {
                        System.out.println("Data is not sorted. Use option 2 first.");
                        break;
                    }
                    int key = InputHelper.readInt("Value to search: ");
                    Searching.Result lin = Searching.linear(data, key);
                    Searching.Result bin = Searching.binary(data, key);
                    System.out.println("=============================================");
                    System.out.printf("%-10s %-16s %-8s %-10s%n", "Operation", "Algorithm", "Steps", "Time(ns)");
                    System.out.printf("%-10s %-16s %-8d %-10d%n", "Search", "Linear Search", lin.steps, lin.nanos);
                    System.out.printf("%-10s %-16s %-8d %-10d%n", "Search", "Binary Search", bin.steps, bin.nanos);
                    System.out.println("=============================================");
                    ResultLog.add("Compare search " + key + ": Linear steps=" + lin.steps + ", Binary steps=" + bin.steps);
                    break;
                }
                case 6: array.display(); break;
                case 7: return;
            }
        }
    }

    private static void printSearch(String name, int key, Searching.Result r) {
        String msg = r.index >= 0 ? "found at index " + r.index : "not found";
        System.out.println(name + " search: " + key + " " + msg + ". Steps: " + r.steps + ", Time: " + r.nanos + " ns");
        ResultLog.add(name + " search " + key + ": " + msg + " (steps " + r.steps + ")");
    }

    // ---------------- GRAPH ----------------
    private static void graphMenu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            switch (InputHelper.readChoice(1, 7)) {
                case 1: {
                    int v = InputHelper.readInt("Vertex id: ");
                    System.out.println(graph.addVertex(v) ? "Vertex " + v + " added." : "Vertex already exists.");
                    break;
                }
                case 2: {
                    int a = InputHelper.readInt("From vertex: ");
                    int b = InputHelper.readInt("To vertex: ");
                    String err = graph.addEdge(a, b);
                    System.out.println(err == null ? "Edge " + a + " - " + b + " added." : "Error: " + err);
                    break;
                }
                case 3: graph.display(); break;
                case 4: traverse(true); break;
                case 5: traverse(false); break;
                case 6: {
                    graph = new Graph();
                    for (int i = 0; i < 7; i++) graph.addVertex(i);
                    int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
                    for (int[] e : edges) graph.addEdge(e[0], e[1]);
                    System.out.println("Sample graph loaded.");
                    graph.display();
                    break;
                }
                case 7: return;
            }
        }
    }

    private static void traverse(boolean bfs) {
        if (graph.isEmpty()) { System.out.println("Graph is empty. Add vertices first."); return; }
        int start = InputHelper.readInt("Start vertex: ");
        if (!graph.hasVertex(start)) { System.out.println("Vertex does not exist."); return; }
        Graph.Traversal t = bfs ? graph.bfs(start) : graph.dfs(start);
        String name = bfs ? "BFS" : "DFS";
        System.out.println(name + " order: " + t.order);
        System.out.println("Steps: " + t.steps + ", Time: " + t.nanos + " ns");
        ResultLog.add(name + " from " + start + ": " + t.order + " (steps " + t.steps + ")");
    }
}

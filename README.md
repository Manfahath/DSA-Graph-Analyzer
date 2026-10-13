# Data Structure & Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms – Graded Practical Assignment 2 (Week 12)
**Language:** Java (console-based application)

## Project Description

A single integrated console application that demonstrates the practical use of
data structures, searching algorithms, graph traversal and algorithmic complexity.
Users operate each structure through menus and can compare the number of steps and
execution time of different algorithms.

## Team Members

> **Fill in every member's details exactly before submitting. Missing or incorrect information may lose marks.**

### Member 1
- **Student Name:** Mohemmad Manfahath
- **Student ID:** <23da2-0655>
- **GitHub Username:** <Manfahath>
- **Assigned Responsibility:** Array and Searching implementation
- **Individual Contribution:**
  - Implemented `DynamicArray` (insert, append, delete, search, display)
  - Implemented `Searching` (linear search, binary search, insertion sort, sorted-data check)
  - Implemented the Array and Searching submenus in `Main` (`arrayMenu`, `searchMenu`)
  - Implemented step counting and the Linear vs Binary search comparison

### Member 2
- **Student Name:** Fathima Misna
- **Student ID:** <23da2-1143>
- **GitHub Username:** <23da2-1143>
- **Assigned Responsibility:** Stack, Queue and utility classes
- **Individual Contribution:**
  - Implemented `ArrayStack` (push, pop, peek, display, overflow/underflow handling)
  - Implemented `CircularQueue` (enqueue, dequeue, peek, display, circular wrap-around, overflow/underflow handling)
  - Implemented `InputHelper` (validated numeric input)
  - Implemented `ResultLog` (log used by "Display All Results")
  - Implemented the Stack and Queue submenus in `Main` (`stackMenu`, `queueMenu`)

### Member 3
- **Student Name:** Hameed Hafila
- **Student ID:** <23da2-960>
- **GitHub Username:** <HafilaHameed>
- **Assigned Responsibility:** Linked List implementation and performance comparison
- **Individual Contribution:**
  - Implemented `SinglyLinkedList` (insert head/tail/position, delete, search, display)
  - Implemented `PerformanceAnalyzer` (searching, graph traversal and insertion benchmarks)
  - Implemented the Linked List submenu in `Main` (`listMenu`)

### Member 4
- **Student Name:** Ayman Methal
- **Student ID:** <23da2-676>
- **GitHub Username:** <aymanmethal2000>
- **Assigned Responsibility:** Graph implementation, main menu, integration and testing
- **Individual Contribution:**
  - Implemented `Graph` (adjacency list, add vertex, add edge, display)
  - Implemented BFS and DFS traversal
  - Implemented the Graph submenu in `Main` (`graphMenu`) and the main menu
  - Integrated all modules and tested the complete system
  - Prepared `README.md`, `run.sh`, `run.bat` and `.gitignore`

## Technologies Used
- Java 11 or later (JDK)
- Git / GitHub for collaboration

## Main System Features
| Component | Features |
|-----------|----------|
| Array | Insert, append, delete, search, display (with step counts) |
| Stack | Push, pop, peek, display; handles empty/full stack |
| Queue | Enqueue, dequeue, peek, display (circular); handles empty/full queue |
| Linked List | Insert head/tail/position, delete, search, display |
| Searching | Linear vs binary search with steps and time; sorted-data check |
| Graph | Add vertex, add edge, display, BFS, DFS, sample graph |
| Performance | Searching, graph traversal and insertion benchmarks |
| Results | Log of all operations via "Display All Results" |
| Validation | All numeric input validated; invalid operations handled |

## Work Distribution by File
| File | Member |
|------|--------|
| `DynamicArray.java`, `Searching.java` | Member 1 |
| `ArrayStack.java`, `CircularQueue.java`, `InputHelper.java`, `ResultLog.java` | Member 2 |
| `SinglyLinkedList.java`, `PerformanceAnalyzer.java` | Member 3 |
| `Graph.java`, `Main.java` (main menu and integration) | Member 4 |

## Complexity Summary
| Operation | Complexity |
|-----------|-----------|
| Array insert/delete (middle) | O(n) |
| Array search (linear) | O(n) |
| Binary search (sorted) | O(log n) |
| Stack push/pop/peek | O(1) |
| Queue enqueue/dequeue/peek | O(1) |
| Linked list insert at head | O(1) |
| Linked list insert at tail / search / delete | O(n) |
| Graph BFS / DFS (adjacency list) | O(V + E) |

## How to Run
Requires JDK 11+.

```bash
# From the project root
mkdir -p out
javac -d out src/*.java
java -cp out Main
```

On Windows you can also double-click `run.bat`; on Linux/macOS run `./run.sh`.

## Repository Structure
```
DSAGraphAnalyzer/
├── src/            Java source files
├── run.sh / run.bat
├── .gitignore
└── README.md
```

## Collaboration (GitHub)
Each member works on their own branch, commits only their own files with meaningful
messages, and merges through pull requests:

| Member | Branch |
|--------|--------|
| Member 1 | `feature/array-searching` |
| Member 2 | `feature/stack-queue` |
| Member 3 | `feature/linkedlist-performance` |
| Member 4 | `feature/graph-integration` |


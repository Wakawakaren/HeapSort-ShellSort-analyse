# Assignment 2: Heap Sort Implementation

This project contains a Java implementation of the **in-place Heap Sort** algorithm.
[cite_start]This work was completed as part of Assignment 2 for the "Algorithmic Analysis" course, specifically for **Pair 2, Student B**.

## Features

- [cite_start]**In-Place Heap Sort**: The algorithm sorts the array without requiring significant auxiliary space.
- [cite_start]**Bottom-Up Heapify**: Uses an efficient O(n) method to build the initial max-heap.
- [cite_start]**Performance Tracking**: Collects metrics on key operations like comparisons, swaps, and array accesses.
- [cite_start]**Comprehensive Tests**: Includes a full suite of JUnit 5 tests covering edge cases[cite: 23, 98].
- [cite_start]**CLI Benchmark Runner**: A command-line interface to test the algorithm's performance on various input sizes[cite: 26].

## How to Run

1.  **Clone the repository.**
2.  **Build the project using Maven:**
    ```bash
    mvn clean install
    ```
3.  **Run the benchmark runner:**
    ```bash
    java -cp target/assignment2-heapsort-1.0-SNAPSHOT.jar cli.BenchmarkRunner
    ```
    The output will be in CSV format, ready for analysis and plotting.

## Algorithmic Complexity Analysis

[cite_start]This section provides the theoretical analysis required for the report[cite: 49].

### Time Complexity

-   **Best Case: $O(n \log n)$**
    -   Even if the array is already sorted, Heap Sort must still go through the process of building the heap ($O(n)$) and then extracting each of the `n` elements ($O(\log n)$ for each extraction).
-   **Average Case: $\Theta(n \log n)$**
    -   The complexity is dominated by the `n` "extract-max" operations, each taking logarithmic time. The initial heap building is faster ($O(n)$), but does not change the overall complexity.
-   **Worst Case: $O(n \log n)$**
    -   The worst-case performance is consistent. Unlike Quick Sort, Heap Sort does not have a degenerate $O(n^2)$ case. The height of the heap is always balanced, guaranteeing $O(\log n)$ for heapify operations.

### Space Complexity

-   **Auxiliary Space: $O(1)$**
    -   [cite_start]The implementation is **in-place**. Sorting is performed directly on the input array, using only a constant amount of extra variables for loops and swaps.
-   **Recursive Stack Space: $O(\log n)$**
    -   The `heapify` function is recursive. In the worst case, the recursion depth is equal to the height of the heap, which is $\log n$. This space is used on the call stack. (Note: It can be converted to an iterative version to achieve true $O(1)$ space).
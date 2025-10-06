package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSortTest {

    private HeapSort heapSort;
    private PerformanceTracker tracker;

    @BeforeEach
    void setUp() {
        heapSort = new HeapSort();
        tracker = new PerformanceTracker();
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        heapSort.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {42};
        int[] expected = {42};
        heapSort.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        heapSort.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6};
        heapSort.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {5, 2, 9, 1, 5, 6, 5};
        int[] expected = {1, 2, 5, 5, 5, 6, 9};
        heapSort.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRandomUnsortedArray() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] expected = {3, 9, 10, 27, 38, 43, 82};
        heapSort.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }
}
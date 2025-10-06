package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {
    public void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, tracker);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i, tracker);
            heapify(arr, i, 0, tracker);
        }
    }

    private void heapify(int[] arr, int n, int i, PerformanceTracker tracker) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        tracker.incrementArrayAccesses(2);
        if (left < n) {
            tracker.incrementArrayAccesses(2);
            tracker.incrementComparisons();
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }
        if (right < n) {
            tracker.incrementArrayAccesses(2);
            tracker.incrementComparisons();
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }
        if (largest != i) {
            swap(arr, i, largest, tracker);
            heapify(arr, n, largest, tracker);
        }
    }

    private void swap(int[] arr, int i, int j, PerformanceTracker tracker) {
        tracker.incrementArrayAccesses(2);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        tracker.incrementArrayAccesses(2);
        tracker.incrementSwaps();
    }
}
package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        System.out.println("Running Heap Sort Benchmarks...");
        int[] sizes = {100, 1000, 10000, 100000};
        HeapSort sorter = new HeapSort();
        PerformanceTracker tracker = new PerformanceTracker();

        System.out.println("Size,Time(ms),Comparisons,Swaps,ArrayAccesses");

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            tracker.reset();
            long startTime = System.nanoTime();
            sorter.sort(arr, tracker);
            long endTime = System.nanoTime();
            long durationMillis = (endTime - startTime) / 1_000_000;
            System.out.printf("%d,%d,%s%n", size, durationMillis, tracker.toCsv());
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }
}
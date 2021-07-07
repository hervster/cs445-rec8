package cs445.rec8;

import java.util.Random;

public class SortTiming {

    // Random number generator for shuffling
    private static Random rand = new Random();
    // Static array that will be reused through all tests
    private static Integer[] a;

    private static final String sep = ",";

    public static void main(String[] args) {

        // number of trials to average for each test
        int numTrials = 1000;
        // min array size
        int minSize = 25;
        // max array size
        int maxSize = 2000;
        // step size when increasing array size
        int step = 25;

        // NOTE:
        // Sometimes, there is a very sudden drop-off in runtime as the JVM's heavy optimizations
        // suddenly kick in. The below allows those optimizations to kick in before the actual
        // timing is done.
        //
        // Run a bunch of stuff before recording, to enable the JVM
        // optimizations to take effect
        //
        a = buildArray(100);
        for (int i = 0; i < 100; i++) {
            timeBubbleSort(numTrials);
            // TODO: Uncomment once implemented
            timeSelectionSort(numTrials);
            timeInsertionSort(numTrials);
            timeShellSort(numTrials);
        }

        // print data header
        System.out.println("size" + sep + "bubble" + sep + "select" + sep + "insert" + sep + "shells");

        // test each size with shuffled array
        for (int size = minSize; size <= maxSize; size += step) {
            a = buildArray(size);
            // print the current size
            System.out.print(size + sep);
            // print the time for bubble sort
            System.out.print(timeBubbleSort(numTrials) + sep);
            // print the time for selection sort
            System.out.print(timeSelectionSort(numTrials) + sep);
            // print the time for insertion sort
            System.out.print(timeInsertionSort(numTrials) + sep);
            // print the time for shellsort
            System.out.print(timeShellSort(numTrials));
            // end the line
            System.out.println("");
        }

    }

    /**
     * time bubble sort for given number of trials
     */
    public static long timeBubbleSort(int numTrials) {
        long time = 0;
        // repeat the test for the specified number of trials
        for (int trial = 0; trial < numTrials; trial++) {
            // shuffle the array
            shuffle(a);
            // determine the time right before calling bubble sort
            long start = System.nanoTime();
            // call bubble sort
            Sorting.bubbleSort(a);
            // determine the time that's elapsed
            time += System.nanoTime() - start;
        }
        // return the average per trial
        return time/numTrials;
    }

    /**
     * time selection sort for given number of trials
     */
    public static long timeSelectionSort(int numTrials) {
        long time = 0;
        // repeat the test for the specified number of trials
        for (int trial = 0; trial < numTrials; trial++) {
            // shuffle the array
            shuffle(a);
            // determine the time right before calling selection sort
            long start = System.nanoTime();
            // call selection sort
            Sorting.selectionSort(a);
            // determine the time that's elapsed
            time += System.nanoTime() - start;
        }
        // return the average per trial
        return time/numTrials;
    }

    /**
     * time insertion sort for given number of trials
     */
    public static long timeInsertionSort(int numTrials) {
        long time = 0;
        // repeat the test for the specified number of trials
        for (int trial = 0; trial < numTrials; trial++) {
            // shuffle the array
            shuffle(a);
            // determine the time right before calling insertion sort
            long start = System.nanoTime();
            // call insertion sort
            Sorting.insertionSort(a);
            // determine the time that's elapsed
            time += System.nanoTime() - start;
        }
        // return the average per trial
        return time/numTrials;
    }

    /**
     * time shellsort for given number of trials
     */
    public static long timeShellSort(int numTrials) {
        long time = 0;
        // repeat the test for the specified number of trials
        for (int trial = 0; trial < numTrials; trial++) {
            // shuffle the array
            shuffle(a);
            // determine the time right before calling shellsort
            long start = System.nanoTime();
            // call shellsort
            Sorting.shellSort(a);
            // determine the time that's elapsed
            time += System.nanoTime() - start;
        }
        // return the average per trial
        return time/numTrials;
    }

    /**
     * generate an Integer array with values 0 to cap
     */
    public static Integer[] buildArray(int cap) {
        Integer[] result = new Integer[cap];
        for (int i = 0; i < cap; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * Shuffle an array to a random permutation using the Fisher-Yates shuffle
     */
    public static <T> void shuffle(T[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = rand.nextInt(i+1);
            Sorting.swap(a, i, r);
        }
    }

}


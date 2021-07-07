package cs445.rec8;

import java.util.Random;

public class Sorting {

    // Random number generator for shuffling
    private static Random rand = new Random();

    /**
     * basic swap method
     */
    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * bubble sort
     */
    public static <T extends Comparable<? super T>>
    void bubbleSort(T[] a) {
        int n = a.length;
        boolean swapped = true;
        for (int i = 0; i < n-1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < n-1-i; j++) {
                if (a[j].compareTo(a[j+1]) > 0) {
                    swap(a, j, j+1);
                    swapped = true;
                }
            }
        }
    }

    /**
     * selection sort
     */
    public static <T extends Comparable<? super T>>
    void selectionSort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    /**
     * shell sort with simple gap sequence
     */
    public static <T extends Comparable<? super T>>
    void shellSort(T[] a) {
        int n = a.length;
        int gap = n/2;
        while (gap > 0) {
            for (int slice = 0; slice < gap; slice++) {
                gapInsertionSort(a, gap, slice);
            }
            gap /= 2;
        }
    }

    /**
     * insertion sort
     */
    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a) {
        for (int unsorted = 1; unsorted < a.length; unsorted++) {
            T toInsert = a[unsorted];
            int i = unsorted-1;
            while (i >= 0 && a[i].compareTo(toInsert) > 0) {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = toInsert;
        }
    }

    /**
     * "gap-aware" insertion sort
     */
    public static <T extends Comparable<? super T>>
    void gapInsertionSort(T[] a, int gap, int slice) {
        for (int unsorted = slice + gap; unsorted < a.length; unsorted += gap) {
            T toInsert = a[unsorted];
            int i = unsorted-gap;
            while (i >= 0 && a[i].compareTo(toInsert) > 0) {
                a[i+gap] = a[i];
                i -= gap;
            }
            a[i+gap] = toInsert;
        }
    }

    /**
     * regular quick sort wrapper
     * @param a The array to sort
     */
    public static <T extends Comparable<? super T>>
    void quickSort(T[] a)
    {
        quickSort(a, 0, a.length);
    }

    /**
     * quicksort recursive method
     * @param a, the array to be sorted
     * @param start, the position of the first element in the array
     * @param end, the position of the last element in the array
     */
    private static <T extends Comparable<? super T>>
    void quickSort(T[] a, int start, int end) {
        if (end - start > 1) {
            int pivotIndex = partition(a, start, end);
            quickSort(a, start, pivotIndex);
            quickSort(a, pivotIndex + 1, end);
        }
    }

    /**
     * hybrid quicksort wrapper
     * @param a, the array to be sorted
     * @param baseCase, the base case size that would cause recursion to stop earlier
     */
    public static <T extends Comparable<? super T>>
    void hybridQuickSort(T[] a, int baseCase) {
        // TODO: implement the hybridQuickSort approach with the baseCase given
        // as an argument
    }

    /**
     * hybrid quicksort method
     * @param a, the array to be sorted
     * @param baseCase, the base case size that would cause recursion to stop earlier
     */
    private static <T extends Comparable<? super T>>
    void hybridQuickSort(T[] a, int baseCase, int start, int end)
    {
        // TODO: implement this method such that
        // it accepts a base case size as an argument
    }

    /**
     * quicksort partition method.
     * @param a, the array to be partitioned
     * @param start, the position of the current first element in the array
     * @param end, the position of the current last element in the array
     * @return the index of the new pivot, after partitioning
     */
    private static <T extends Comparable<? super T>>
    int partition(T[] a, int start, int end) {
        int pivotIndex = end - 1, lo = start, hi = end - 2;
        T pivot = a[pivotIndex];
        boolean done = false;

        while (!done) {
            while (a[lo].compareTo(pivot) < 0) {
                lo++;
            }

            while (a[hi].compareTo(pivot) > 0 && hi > start) {
                hi--;
            }

            if (lo < hi) {
                swap(a, lo, hi);
                lo++;
                hi--;
            } else {
                done = true;
            }
        }

        swap(a, pivotIndex, lo);
        pivotIndex = lo;

        return pivotIndex;
    }

    /**
     * generate an int array with values 0 to cap
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


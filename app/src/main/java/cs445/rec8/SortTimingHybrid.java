package cs445.rec8;

public class SortTimingHybrid {

    // Static array that will be reused through all tests
    private static Integer[] a;

    private static final String sep = ",";

    public static void main(String[] args) {

        // number of trials to average for each test
        int numTrials = 1000;
        // min array size
        int minSize = 5;
        // max array size
        int maxSize = 200;
        // step size when increasing array size
        int step = 1;
        // base case for hybridQuickSort()
        int baseCase = 1;

        // NOTE:
        // Sometimes, there is a very sudden drop-off in runtime as the JVM's heavy optimizations
        // suddenly kick in. The below allows those optimizations to kick in before the actual
        // timing is done.
        //
        // Run a bunch of stuff before recording, to enable the JVM
        // optimizations to take effect
        //
        a = Sorting.buildArray(100);
        for (int i = 0; i < 100; i++) {
            timeInsertionSort(numTrials);
            timeQuickSort(numTrials);
            // Uncomment once implemented
            //timeHybridQuicksort(numTrials, baseCase);
        }

        // print data header
        System.out.println("size" + sep + "isort" + sep + "qsort"/* + sep + "qsortHyb"*/);

        // test each size
        for (int size = minSize; size <= maxSize; size += step) {
            a = Sorting.buildArray(size);
            // print the current size
            System.out.print(size + sep);
            // print the time for insertion sort
            System.out.print(timeInsertionSort(numTrials) + sep);
            // print the time for original quick sort
            System.out.print(timeQuickSort(numTrials) + sep);
            // print the time for modified quick sort with insertion sort for small sizes
            //System.out.print(timeHybridQuicksort(numTrials, baseCase));
            // end the line
            System.out.println("");
        }
    }

    /**
     * time quicksort for given number of trials
     */
    public static long timeQuickSort(int numTrials) {
        long time = 0;
        // repeat the test for the specified number of trials
        for (int trial = 0; trial < numTrials; trial++) {
            // shuffle the array
            Sorting.shuffle(a);
            // determine the time right before calling quickSort
            long start = System.nanoTime();
            // call quickSort
            Sorting.quickSort(a);
            // determine the time that's elapsed
            time += System.nanoTime() - start;
        }
        // return the average per trial
        return time/numTrials;
    }

    /**
     * time improved quicksort for given number of trials
     * @param numTrials, number of trials for each test
     * @param baseCase, the base case size for hybridQuickSort method
     * @return the average time taken by each trial
     */
    public static long timeHybridQuicksort(int numTrials, int baseCase) {
        // TODO: Implement this method to utilize insertionSort/quickSort hybrid with some baseCase for switching
        return 0;
    }

    /**
     * time insertion sort for given number of trials
     */
    public static long timeInsertionSort(int numTrials) {
        long time = 0;
        // repeat the test for the specified number of trials
        for (int trial = 0; trial < numTrials; trial++) {
            // shuffle the array
            Sorting.shuffle(a);
            // determine the time right before calling insertion sort
            long start = System.nanoTime();
            // call insertionSort
            Sorting.insertionSort(a);
            // determine the time that's elapsed
            time += System.nanoTime() - start;
        }
        // return the average per trial
        return time/numTrials;
    }

}


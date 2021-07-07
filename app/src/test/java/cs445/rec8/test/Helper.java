package cs445.rec8.test;

public class Helper {

    public static <T extends Comparable<? super T>>
    boolean isSorted(T[] a) {
        for (int i = 0; i < a.length-1; i++) {
            if (a[i+1].compareTo(a[i]) < 0) {
                return false;
            }
        }
        return true;
    }

}


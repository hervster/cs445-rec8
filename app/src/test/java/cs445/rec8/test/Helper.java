package cs445.rec8.test;

import java.util.Random;

import cs445.rec8.Sorting;

public class Helper {

	static Random rand = new Random();

	public static <T extends Comparable<? super T>>
	boolean isSorted(T[] a) {
		for (int i = 0; i < a.length-1; i++) {
			if (a[i+1].compareTo(a[i]) < 0) {
				return false;
			}
		}
		return true;
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

}


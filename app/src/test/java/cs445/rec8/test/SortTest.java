package cs445.rec8.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cs445.rec8.Sorting;

public class SortTest{

    Integer[] a;

    @AfterEach
    public void teardown(){
        a = null;
    }

    @Test
    @DisplayName("Test QuickSortHybrid")
    void testQuicksort_Hybrid(){

        int minSize = 100;
        int maxSize = 5000;
        int step = 100;
        int baseCase = 20;

        for (int i = minSize; i <= maxSize; i+=step) {
            a = Sorting.buildArray(i);

            Sorting.shuffle(a);
            Sorting.hybridQuickSort(a, baseCase);
            assert Helper.isSorted(a);
        }

    }

}


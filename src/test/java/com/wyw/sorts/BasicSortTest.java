package com.wyw.sorts;

import com.wyw.utils.RandomUtils;
import com.wyw.utils.SortUtils;

import java.util.Arrays;

public class BasicSortTest {
    static void sort(SortAlgorithm sortAlgorithm) {
        int testTime = 100;
        int arrayLength = 100;
        int origin = -1000000;
        int bound = 10000000;
        for (int i = 0; i < testTime; i++) {
            Integer[] arr = new Integer[arrayLength];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = RandomUtils.nextInt(origin, bound);
            }

            sortAlgorithm.sort(arr);
            System.out.println(Arrays.toString(arr));
            assert (SortUtils.isSorted(arr));
        }
    }
}
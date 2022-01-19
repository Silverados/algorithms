package com.wyw.sorts;

import static com.wyw.utils.SortUtils.less;
import static com.wyw.utils.SortUtils.swap;

public class InsertionSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        if (unsorted == null || unsorted.length < 2) {
            return unsorted;
        }

        for (int i = 1; i < unsorted.length; i++) {
            for (int j = 0; j < i; j++) {
                if (less(unsorted[i], unsorted[j])) {
                    swap(unsorted, i, j);
                }
            }
        }

        return unsorted;
    }
}

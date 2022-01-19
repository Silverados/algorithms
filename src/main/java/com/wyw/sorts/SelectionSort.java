package com.wyw.sorts;


import static com.wyw.utils.SortUtils.less;
import static com.wyw.utils.SortUtils.swap;

public class SelectionSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        if (unsorted == null || unsorted.length == 0) {
            return unsorted;
        }

        for (int i = 0; i < unsorted.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < unsorted.length; j++) {
                if (less(unsorted[j], unsorted[minIndex])) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(unsorted, i, minIndex);
            }
        }

        return unsorted;
    }

}

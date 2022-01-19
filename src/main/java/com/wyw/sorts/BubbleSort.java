package com.wyw.sorts;

import static com.wyw.utils.SortUtils.greater;
import static com.wyw.utils.SortUtils.swap;

public class BubbleSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        if (unsorted == null || unsorted.length < 2) {
            return unsorted;
        }

        for (int i = unsorted.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(unsorted[j], unsorted[j + 1])) {
                    swap(unsorted, j, j + 1);
                }
            }
        }

        return unsorted;
    }
}

package com.wyw.sorts;

import static com.wyw.utils.SortUtils.*;

public class QuickSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        if (unsorted == null || unsorted.length < 2) {
            return unsorted;
        }

        sort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    private <T extends Comparable<T>> void sort(T[] unsorted, int left, int right) {
        if (left < right) {
            swap(unsorted, right, (int) (left + Math.random() * (right - left + 1)));
            int[] p = partition(unsorted, left, right);
            sort(unsorted, left, p[0] - 1);
            sort(unsorted, p[1] + 1, right);
        }
    }

    private <T extends Comparable<T>> int[] partition(T[] unsorted, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (less(unsorted[left], unsorted[right])) {
                swap(unsorted, left++, ++less);
            } else if (greater(unsorted[left], unsorted[right])) {
                swap(unsorted, left, --more);
            } else {
                less++;
            }
        }
        swap(unsorted, more, right);
        return new int[]{less + 1, more};
    }
}

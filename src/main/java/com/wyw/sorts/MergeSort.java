package com.wyw.sorts;

import static com.wyw.utils.SortUtils.less;

public class MergeSort implements SortAlgorithm{
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
            int mid = (right + left) >>> 1;
            sort(unsorted, left, mid);
            sort(unsorted, mid + 1, right);
            merge(unsorted, left, mid, right);
        }
    }

    private <T extends Comparable<T>> void merge(T[] unsorted, int left, int mid, int right) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            temp[index++] = less(unsorted[i], unsorted[j]) ? unsorted[i++] : unsorted[j++];
        }

        while (i <= mid) {
            temp[index++] = unsorted[i++];
        }

        while (j <= right) {
            temp[index++] = unsorted[j++];
        }

        System.arraycopy(temp, 0, unsorted, left, temp.length);
    }
}

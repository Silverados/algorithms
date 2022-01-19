package com.wyw.sorts;

import static com.wyw.utils.SortUtils.*;

public class HeapSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        if (unsorted == null || unsorted.length < 2) {
            return unsorted;
        }

        for (int i = 0; i < unsorted.length; i++) {
            heapInsert(unsorted, i);
        }

        int size = unsorted.length;
        swap(unsorted, 0, --size);

        while (size > 0) {
            heapify(unsorted, 0, size);
            swap(unsorted, 0, --size);
        }

        return unsorted;
    }

    private <T extends Comparable<T>> void heapify(T[] unsorted, int i, int size) {
        int left = 2 * i + 1;
        while (left < size) {
            int largest = left + 1 < size && greater(unsorted[left + 1], unsorted[left]) ? left + 1 : left;
            largest = greater(unsorted[largest], unsorted[i]) ? largest : i;
            if (largest == i) {
                return;
            }

            swap(unsorted, largest, i);
            i = largest;
            left = 2 * i + 1;
        }
    }


    private <T extends Comparable<T>> void heapInsert(T[] unsorted, int i) {
        while ((i - 1) / 2 >= 0 && greater(unsorted[i], unsorted[(i - 1) / 2])) {
            swap(unsorted, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }


}

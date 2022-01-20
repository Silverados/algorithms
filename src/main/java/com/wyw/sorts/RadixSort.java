package com.wyw.sorts;

import java.util.Arrays;
import java.util.function.Consumer;

public class RadixSort implements Consumer<Integer[]> {
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int[] radixSort(int[] unsorted) {
        if (unsorted == null || unsorted.length < 2) {
            return unsorted;
        }

        int max = getMax(unsorted);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(unsorted, exp);
        }
        return unsorted;
    }

    public static Integer[] radixSort(Integer[] unsorted) {
        int[] sorted = radixSort(Arrays.stream(unsorted).mapToInt(Integer::intValue).toArray());
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = sorted[i];
        }
        return unsorted;
    }

    private static void countSort(int[] unsorted, int exp) {
        int[] res = new int[unsorted.length];
        int[] count = new int[10];

        // 统计某位上的次数
        for (int i = 0; i < unsorted.length; i++) {
            count[(unsorted[i] / exp) % 10]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = unsorted.length - 1; i >= 0; i--) {
            res[--count[(unsorted[i] / exp) % 10]] = unsorted[i];
        }

        System.arraycopy(res, 0, unsorted, 0, unsorted.length);
    }

    @Override
    public void accept(Integer[] integers) {
        radixSort(integers);
    }
}

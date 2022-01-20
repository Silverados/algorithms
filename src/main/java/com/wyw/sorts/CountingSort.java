package com.wyw.sorts;

import java.util.Map;
import java.util.TreeMap;

public class CountingSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        if (unsorted == null || unsorted.length < 2) {
            return unsorted;
        }

        Map<T, Integer> frequency = new TreeMap<>();
        for (T v : unsorted) {
            frequency.put(v, frequency.getOrDefault(v, 0) + 1);
        }

        int index = 0;
        for (Map.Entry<T, Integer> entry : frequency.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                unsorted[index++] = entry.getKey();
            }
        }

        return unsorted;
    }
}

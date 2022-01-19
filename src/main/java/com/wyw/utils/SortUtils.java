package com.wyw.utils;

public class SortUtils {
    public static <T> boolean swap(T[] arr, int x, int y) {
        if (x < 0 || y < 0 || x >= arr.length || y >= arr.length) {
            return false;
        }
        T val = arr[x];
        arr[x] = arr[y];
        arr[y] = val;
        return true;
    }

    public static <T extends Comparable<T>> boolean less(T x, T y) {
        return x.compareTo(y) < 0;
    }

    public static <T extends Comparable<T>> boolean lessOrEqual(T x, T y) {
        return x.compareTo(y) <= 0;
    }

    public static <T extends Comparable<T>> boolean greater(T x, T y) {
        return x.compareTo(y) > 0;
    }

    public static <T extends Comparable<T>> boolean greaterOrEqual(T x, T y) {
        return x.compareTo(y) >= 0;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (greater(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }
}

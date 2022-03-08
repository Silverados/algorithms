package com.wyw.utils;

public class ArrayUtils {
    public static String deepToString(long[][] dp) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i = 0; i < dp.length; i++) {
            long[] longs = dp[i];
            buf.append("[");
            for (int j = 0; j < longs.length; j++) {
                buf.append(longs[j]);
                if (j != longs.length - 1) {
                    buf.append(',');
                }
            }
            if (i != dp.length - 1) {
                buf.append("]\n");
            } else {
                buf.append("]");
            }
        }
        buf.append("]");
        return buf.toString();
    }

    public static String deepToString(int[][] dp) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i = 0; i < dp.length; i++) {
            int[] ints = dp[i];
            buf.append("[");
            for (int j = 0; j < ints.length; j++) {
                buf.append(ints[j]);
                if (j != ints.length - 1) {
                    buf.append(',');
                }
            }
            if (i != dp.length - 1) {
                buf.append("]\n");
            } else {
                buf.append("]");
            }
        }
        buf.append("]\n");
        return buf.toString();
    }
}

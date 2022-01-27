package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return res;
        }

        List<String> temp = new ArrayList<>();
        backtrace(s.toCharArray(), res, temp, 0);
        return res;
    }

    private static void backtrace(char[] s, List<List<String>> res, List<String> temp, int index) {
        if (index == s.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length; i++) {
            if (isValid(s, index, i)) {
                temp.add(new String(s, index, i - index + 1));
                backtrace(s, res, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }

    private static boolean isValid(char[] s, int i, int j) {
        while (i < j) {
            if (s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

}

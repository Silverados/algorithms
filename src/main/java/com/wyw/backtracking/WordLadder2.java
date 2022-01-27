package com.wyw.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder2 {
    private static int min;
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }

        min = wordList.size();
        temp.add(beginWord);
        backtrace(beginWord, endWord, wordList, res, temp, 0);
        return res.stream().filter(x -> x.size() == min).collect(Collectors.toList());
    }

    private static void backtrace(String beginWord, String endWord, List<String> wordList, List<List<String>> res, List<String> temp, int index) {
        if (temp.size() > min) {
            return;
        }
        if (beginWord.equals(endWord)) {
            min = temp.size();
            res.add(new ArrayList<>(temp));
            return;
        }

        List<String> strings = find(wordList, temp, beginWord);
        for (int i = 0; i < strings.size(); i++) {
            String word = beginWord;
            beginWord = strings.get(i);
            temp.add(beginWord);
            backtrace(beginWord, endWord, wordList, res, temp, i + 1);
            temp.remove(temp.size() - 1);
            beginWord =  word;
        }


    }

    private static List<String> find(List<String> wordList, List<String> temp, String word) {
        List<String> res = new ArrayList<>();
        for (String s : wordList) {
            if (isValid(s, word) && !temp.contains(s)) {
                res.add(s);
            }
        }
        return res;
    }

    private static boolean isValid(String beginWord, String s) {
        return getDiff(beginWord, s) == 1;
    }

    private static int getDiff(String beginWord, String s) {
        int diff = s.length();
        for (int i = 0; i < beginWord.length(); i++) {
            diff -= beginWord.charAt(i) == s.charAt(i) ? 1 : 0;
        }
        return diff;
    }

    // todo
    public static void main(String[] args) {
        List<String> list = List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        System.out.println(findLadders("qa", "sq", list));
//        System.out.println(findLadders("hit", "cog", list));
    }
}

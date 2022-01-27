package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return res;
        }

        backtrace(s, s.toCharArray(), res, new StringBuilder(), 0, 0);
        return res;
    }

    private static void backtrace(String s, char[] chars, List<String> res, StringBuilder sb, int count, int index) {
        if (count > 4) {
            return;
        }

        if (count == 4 && index == chars.length) {
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < chars.length; i++) {
            if (chars.length - i  > 3 * (4 - count)) {
                break;
            }
            if (i - index + 1 > 3) {
                break;
            }
            if (isValid(s, chars, index, i)) {
                int beingIndex = sb.length();
                sb.append(chars, index, i - index + 1);
                if (count < 3) {
                    sb.append('.');
                }
                backtrace(s, chars, res, sb, count + 1, i + 1);

                sb.delete(beingIndex, sb.length());
            }
        }
    }

    private static boolean isValid(String s, char[] chars, int i, int j) {
        int len = j - i + 1;
        if (chars[i] == '0' && len != 1) {
            return false;
        }

        if (len < 3) {
            return true;
        }

        if (len > 3) {
            return false;
        }

        return Integer.parseInt(s, i, j + 1, 10) <= 255;
    }

    public static void main(String[] args) {
//        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
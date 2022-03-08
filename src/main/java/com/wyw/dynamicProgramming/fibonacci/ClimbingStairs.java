package com.wyw.dynamicProgramming.fibonacci;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n <= 2) {
            return n;
        }

        int[] helper = new int[n + 1];
        helper[0] = 0;
        helper[1] = 1;
        helper[2] = 2;

        for (int i = 3; i <= n; i++) {
            helper[i] = helper[i - 1] + helper[i - 2];
        }
        return helper[n];
    }


    public static int climbStairsSaveSpace(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}

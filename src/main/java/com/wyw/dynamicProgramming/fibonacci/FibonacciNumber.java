package com.wyw.dynamicProgramming.fibonacci;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FibonacciNumber {

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int num1 = 0;
        int num2 = 0;
        int res = 1;
        for(int i = 2; i <= n; i++) {
            num1 = num2;
            num2 = res;
            res = num1 + num2;
        }
        return res;
    }

    public int fib2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    public static void main(String[] args) {
        System.out.println(fib(30));
    }
}

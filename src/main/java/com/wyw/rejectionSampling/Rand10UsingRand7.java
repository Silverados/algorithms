package com.wyw.rejectionSampling;

import static com.wyw.utils.RandomUtils.nextInt;

public class Rand10UsingRand7 {

    public static int rand7() {
        return nextInt(7) + 1;
    }

    /**
     * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
     *
     * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
     *
     * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    public static int rand10() {
        int res;
        do {
            int x = rand7();
            int y = rand7();
            res = x + (y - 1) * 7;
        } while (res > 40);
        return 1 + (res - 1) % 10;
    }
}

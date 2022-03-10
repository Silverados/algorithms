package com.wyw.dynamicProgramming.subsequence;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArithmeticSlices {
    /**
     * 1.状态定义：
     *      dp[i] 代表长度>=3的等差以i结尾的子数组的个数
     * 2.边界分析：
     *      if i < 2:
     *          0
     * 3.状态转移：
     *      if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
     *          dp[i] = dp[i - 1] + 1
     *      else:
     *          dp[i] = 0;
     *
     * 结果为dp数组总和
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }

        return res;
    }

    public static int numberOfArithmeticSlices_Base(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j + 1] - nums[j] == nums[i + 1] - nums[i]) {
                    res++;
                } else {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
        System.out.println(numberOfArithmeticSlices_Base(new int[]{1, 2, 3, 4}));
        System.out.println(numberOfArithmeticSlices_Base(new int[]{1}));
        System.out.println(numberOfArithmeticSlices_Base(new int[]{1, 2, 3, 8, 9, 10}));
    }
}

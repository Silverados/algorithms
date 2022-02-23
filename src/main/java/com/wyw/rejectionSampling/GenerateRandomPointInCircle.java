package com.wyw.rejectionSampling;

public class GenerateRandomPointInCircle {
    /**
     * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
     * @param radius
     * @param x
     * @param y
     * @return
     */
    public static double[] randPoint(double radius, double x, double y) {
        while (true) {
            double x1 = x - radius + Math.random() * radius * 2;
            double y1 = y - radius + Math.random() * radius * 2;
            if (Math.pow((x1 - x), 2) + Math.pow((y1 - y), 2) < radius * radius) {
                return new double[]{x1, y1};
            }
        }
    }
}

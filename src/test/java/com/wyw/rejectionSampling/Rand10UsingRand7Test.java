package com.wyw.rejectionSampling;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Rand10UsingRand7Test {

    @Test
    void rand10() {
        int total = 100000;
        int[] helper = new int[10];
        for (int i = 0; i < total; i++) {
            helper[Rand10UsingRand7.rand10() - 1]++;
        }
        System.out.println(Arrays.toString(helper));
    }
}
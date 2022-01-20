package com.wyw.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @Test
    void sort() {
        BasicSortTest.sort(new RadixSort(), 1000, 10000, 0, 10000000);
    }
}
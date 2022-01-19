package com.wyw.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void sort() {
        BasicSortTest.sort(new HeapSort());
    }
}
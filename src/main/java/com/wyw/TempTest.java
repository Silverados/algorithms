package com.wyw;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class TempTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        LocalDate a = LocalDate.of(2022, 3, 10);
        LocalDate b = LocalDate.of(2022, 5, 28);
        System.out.println(a.until(b, ChronoUnit.DAYS));
    }
}

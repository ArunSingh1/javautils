package com.practice.exam;

import java.util.IntSummaryStatistics;
import java.util.Random;

public class stats {
    public static void main(String[] args) {
        final Random random = new Random();
        final int total = 100;
        final IntSummaryStatistics stats = random.ints(total, 0,1000).parallel()
                .map(Integer::valueOf)
                .summaryStatistics();

        final double mean = stats.getAverage();
        final double maxi = stats.getMax();
        final double minii = stats.getMin();
        final double sum = stats.getSum();

        System.out.println(maxi);
        System.out.println(mean);
        System.out.println(minii);
        System.out.println(sum);

    }
}

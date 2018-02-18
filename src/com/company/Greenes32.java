package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Greenes32 {
    public static void createGreenes32(SimpleEnvironment env) {
        // Creating the first portion of Greene's 32
        // Depth 1
        env.createComparison(16, 0, 1);
        env.createComparison(16, 2, 3);
        env.createComparison(16, 4, 5);
        env.createComparison(16, 6, 7);
        env.createComparison(16, 8, 9);
        env.createComparison(16, 10, 11);
        env.createComparison(16, 12, 13);
        env.createComparison(16, 14, 15);
        // Depth 2
        env.createComparison(16, 0, 2);
        env.createComparison(16, 4, 6);
        env.createComparison(16, 8, 10);
        env.createComparison(16, 12, 14);
        // Depth 3
        env.createComparison(16, 1, 3);
        env.createComparison(16, 5, 7);
        env.createComparison(16, 9, 11);
        env.createComparison(16, 13, 15);
        // Depth 4
        env.createComparison(16, 0, 4);
        env.createComparison(16, 8, 12);
        // Depth 5
        env.createComparison(16, 1, 5);
        env.createComparison(16, 9, 13);
        // Depth 6
        env.createComparison(16, 2, 6);
        env.createComparison(16, 10, 14);
        // Depth 7
        env.createComparison(16, 3, 7);
        env.createComparison(16, 11, 15);
        // Depth 8
        env.createComparison(16, 0, 8);
        // Depth 9
        env.createComparison(16, 1, 9);
        // Depth 10
        env.createComparison(16, 2, 10);
        // Depth 11
        env.createComparison(16, 3, 11);
        // Depth 12
        env.createComparison(16, 4, 12);
        // Depth 13
        env.createComparison(16, 5, 13);
        // Depth 14
        env.createComparison(16, 6, 14);
        // Depth 15
        env.createComparison(16, 7, 15);
    }
    public static void main(String[] args) {
        SimpleEnvironment greene = new SimpleEnvironment(16);
        createGreenes32(greene);
        greene.sortData();
        String unsortedValsString = greene.toString();
        System.out.println(unsortedValsString);
    }
}

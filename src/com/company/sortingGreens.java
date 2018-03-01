package com.company;

import java.util.HashSet;

public class sortingGreens {
    /**
     * Creates all of the first 16 comparisons for Greens 32
     * @param env - The environment object for the comparisons to be added onto
     */
    public static void createGreens32(SimpleEnvironment env) {
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

    /**
     * Prints out data about each wire and the amount of 1's and 0's that
     * exist on it in the current set of 151 unsorted values
     * @param unsortedValues - The 151 remaining unsorted strings from the first
     *                       portion of Green's 32.
     */
    public static int[][] wireInfo(HashSet<String> unsortedValues) {
        int[][] wireData = new int[16][2];
        // Iterates through all of the unsorted strings within the set
        for (int i = 0; i <= unsortedValues.iterator().next().length() - 1; i++) {
            int ones = 0;
            int zeros = 0;
            for (String temp : unsortedValues) {
                if (temp.charAt(i) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }
            wireData[i][0] = zeros;
            wireData[i][1] = ones;
        }
        return wireData;
    }

    /**
     * Prints out the data stored within the wire data array
     * @param wireData - The array containing the data about the
     *                 current values on the wires
     */
    public static void readWireInfo(int[][] wireData) {
        System.out.println("   0's  1's");
        for (int i = 0; i < wireData.length; i++) {
            for (int j = 0; j < wireData[i].length; j++) {
                System.out.print("   " + wireData[i][j]);
            }
            System.out.println("   - Wire #" + i);
        }
    }
    /**
     * Main method that creates the Environment containing Greens 32
     * @param args
     */
    public static void main(String[] args) {
        // Sorts a network to Green's 151 unsorted outputs
        SimpleEnvironment green = new SimpleEnvironment(16);
        createGreens32(green);
        green.sortData();

        // Working with the 151 unsorted outputs
        HashSet<String> unsortedGreen = green.unsortedValues;
        int[][] wireData = wireInfo(unsortedGreen);
        readWireInfo(wireData);
    }

}

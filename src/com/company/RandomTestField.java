package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;

public class RandomTestField {
    public static void main(String[] args) {
        System.out.print("Enter the number of wires: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        System.out.print("Enter the number of Random comparisons: ");
        int numComps = in.nextInt();
        SimpleEnvironment TEST = new SimpleEnvironment(size);
        ArrayList<Double> percentages = new ArrayList<>();
        int i = 0;
        Random rand = new Random();
        ArrayList<Integer> numberOfUnsortedOutputs = new ArrayList<Integer>();
        while (i < 100) {
            ArrayList<String> AllData = TEST.generateBinary(size, "");
            int n = 0;
            ArrayList<int[]> possibleComps = TEST.generateComparisons(size);
            while (n < numComps) {
                int[] currentComp = possibleComps.get(rand.nextInt(possibleComps.size()));
                TEST.createComparison(size, currentComp[0], currentComp[1]);
                n++;
            }
            TEST.sortData();
            System.out.println("Current Trial: " + TEST.unsortedValues.size());
            System.out.println(TEST.unsortedValues);
            numberOfUnsortedOutputs.add(TEST.unsortedValues.size());
            i++;
            if (i % 100 == 0){
                System.out.print(".");
            }
        }
        System.out.println();
        double totalPercentages = 0.0;
        int totalUnsorted = 0;
        for (int k = 0; k != numberOfUnsortedOutputs.size(); k++) {
            totalUnsorted += numberOfUnsortedOutputs.get(k);
        }
        System.out.println("Total unsorted: " + totalUnsorted);
        final int NUM_UNSORTED = totalUnsorted / numberOfUnsortedOutputs.size();
        System.out.println("The average number of unsorted outputs is: " + NUM_UNSORTED);
    }
}

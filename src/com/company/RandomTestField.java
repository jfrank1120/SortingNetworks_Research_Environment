package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;

public class RandomTestField {
    public static void main(String[] args) {
        SimpleEnvironment TEST = new SimpleEnvironment();
        System.out.print("Enter the number of wires: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        System.out.print("Enter the number of Random comparisons: ");
        int numComps = in.nextInt();
        ArrayList<Double> percentages = new ArrayList<>();
        int i = 0;
        Random rand = new Random();
        ArrayList<Integer> numberOfUnsortedOutputs = new ArrayList<Integer>();
        while (i < 1000) {
            ArrayList<String> AllData = TEST.generateBinary(size, "");
            int n = 0;
            while (n < numComps) {
                int topPortion = rand.nextInt(size);
                int bottomPortion = rand.nextInt(size);
                if (TEST.createComparison(size, topPortion, bottomPortion)) {
                    n++;
                }
            }
            HashSet<String> unsortedData = TEST.sortData(AllData);
            System.out.println("Current Trial: " + unsortedData.size());
            System.out.println(unsortedData);
            numberOfUnsortedOutputs.add(unsortedData.size());
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

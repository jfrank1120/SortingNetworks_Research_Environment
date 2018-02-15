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
        while (i < 10) {
            ArrayList<String> AllData = TEST.generateBinary(size, "");
            int n = 0;
            while (n < numComps) {
                int topPortion = rand.nextInt(size);
                int bottomPortion = rand.nextInt(size);
                if (TEST.createComparison(size, topPortion, bottomPortion)) {
                    n++;
                }
            }
            ArrayList<String> unsortedData = TEST.sortData(AllData);
            percentages.add(TEST.percentageNotSorted(unsortedData, AllData));
            System.out.println("Current Trial: " + TEST.percentageNotSorted(unsortedData, AllData));
            i++;
            System.out.println("=-=-=-= Loop " + i + " =-=-=-=-=");
        }
        double totalPercentages = 0.0;
        for (int k = 0; k != percentages.size(); k++) {
            totalPercentages += percentages.get(k);
        }
        final double FINAL_PERCENTAGE = totalPercentages / percentages.size();
        System.out.println("The average of all trials is: " + FINAL_PERCENTAGE);

    }
}

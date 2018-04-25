package com.company.Old_Environment;

import java.security.AllPermission;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class RandomTestField {
    public static void main(String[] args) {
        System.out.print("Enter the number of wires: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        //System.out.print("Enter the number of Random comparisons: ");
        //int numComps = in.nextInt();
        int numComps = 0;
        SimpleEnvironment TEST = new SimpleEnvironment(size);
        ArrayList<Double> percentages = new ArrayList<>();
        int i = 0;
        ArrayList<String> AllData = new ArrayList<>();
        Random rand = new Random();
        ArrayList<Integer> numberOfUnsortedOutputs = new ArrayList<Integer>();
        AllData = TEST.generateBinary(size, "");
        TEST.sortData();
        while (i < 100) {
            int n = 0;
            ArrayList<int[]> possibleComps = TEST.generateComparisons(size);
            while (n < numComps) {
                int[] currentComp = possibleComps.get(rand.nextInt(possibleComps.size()));
                TEST.createComparison(size, currentComp[0], currentComp[1]);
                n++;
            }
            //System.out.println("Current Trial: " + TEST.unsortedValues.size());
            //System.out.println(TEST.unsortedValues);
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
        System.out.println("Total Created Strings: " + AllData.size());
        final int NUM_UNSORTED = totalUnsorted / numberOfUnsortedOutputs.size();
        System.out.println("The average number of unsorted outputs is: " + NUM_UNSORTED);
    }
}

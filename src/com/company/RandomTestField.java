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
        System.out.println("Enter the number of Random comparisons: ");
        int numComps = in.nextInt();
        ArrayList<String> AllData = TEST.generateBinary(size, "");
        System.out.println(AllData);
        int n = 0;
        Random rand = new Random();
        while (n != numComps) {
            int topPortion = rand.nextInt(size);
            int bottomPortion = rand.nextInt(size);
            if (TEST.createComparison(size, topPortion, bottomPortion)) {
                n++;
            }
        }
        HashSet<String> unsortedData = TEST.sortData(AllData);
        System.out.print("Unsorted Data: ");
        System.out.println(unsortedData);
        System.out.println("Percentage Unsorted: " + TEST.percentageNotSorted(unsortedData, AllData));
    }
}

package com.company.Main_Env_Networks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Buttom_Up_151 {
    public static void main(String[] args) {
        /*
        int trials = 0;
        ArrayList<Comparator> currentComparisons = new ArrayList<>();
        ArrayList<Integer> trialData = new ArrayList<>();
        double sumComps = 0;
        ComparisonNetwork151 netWork;
        while (trials < 50) {
            do {
                netWork = new ComparisonNetwork151(16, currentComparisons);
                currentComparisons.add(addRandomComparison());
            } while (!(netWork.getBadOutputs().size() == 0));
            sumComps += currentComparisons.size();
            System.out.println("Trail #" + trials);
            currentComparisons.clear();
            trials++;
        }
        System.out.println("Avg Number of comparisons needed: " + (sumComps/trials));
        */
        // Creating Green's 151
        int[][] a = {
                {0, 1}, {2, 3}, {4, 5}, {6, 7}, {8, 9}, {10, 11}, {12, 13}, {14, 15},
                {0, 2}, {4, 6}, {8, 10}, {12, 14},
                {1, 3}, {5, 7}, {9, 11}, {13, 15},
                {0, 4}, {1, 5}, {2, 6}, {3, 7},
                {8, 12}, {9, 13}, {10, 14}, {11, 15},
                {0, 8}, {1, 9}, {2, 10}, {3, 11}, {4, 12}, {5, 13}, {6, 14}, {7, 15},
        };

        // convert to array list of comparators
        ArrayList<Comparator> comparators = new ArrayList<>();
        for (int[] comp : a) {
            comparators.add(new Comparator(comp[0], comp[1]));
        }

        // enumerate unsorted binary outputs
        ComparisonNetwork net = new ComparisonNetwork(16, comparators);
        Set<String> badOutputs = net.getBadOutputs();
        int i = 1;
        System.out.println("Total Unsorted: " + badOutputs.size());
        ArrayList<String> the151 = new ArrayList<>();
        for (String out: badOutputs) {
            the151.add(out);
        }
        int trials = 0;
        ArrayList<Comparator> currentComparisons = new ArrayList<>();
        ArrayList<Integer> trialData = new ArrayList<>();
        double sumComps = 0;
        int numberBad = 151;
        ComparisonNetwork151 netWork;
        while (trials < 50) {
            do {
                netWork = new ComparisonNetwork151(the151, 16, currentComparisons);
                Comparator newComp = addRandomComparison();
                currentComparisons.add(newComp);
                if (netWork.getBadOutputs().size() < numberBad) {
                    numberBad = netWork.getBadOutputs().size();
                    System.out.println(numberBad);
                }
            } while (!(netWork.getBadOutputs().size() == 0));
            sumComps += currentComparisons.size();
            System.out.println("Trail #" + trials);
            currentComparisons.clear();
            trials++;
        }
        System.out.println("Avg Number of comparisons needed (151): " + (sumComps/trials));
    }


    public static Comparator addRandomComparison() {
        ArrayList<Comparator> allPossibleComparators = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            for (int j = i + 1; j < 16; j++) {
                allPossibleComparators.add(new Comparator(i, j));
            }
        }
        // Select comparators at random
        //ArrayList<Comparator> listOfComparators = new ArrayList<>();
        Random rand = new Random();
        int k = rand.nextInt(allPossibleComparators.size());
        return allPossibleComparators.get(k);
    }
}

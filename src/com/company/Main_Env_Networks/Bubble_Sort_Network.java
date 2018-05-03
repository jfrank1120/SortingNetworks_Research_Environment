package com.company.Main_Env_Networks;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Jared Frank
 */
public class Bubble_Sort_Network {


    public static void main(String[] args) {
        // Original Bubble sorting comparisons for the 16 wire sequence
        /*
        int[][] a = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6},
                {6, 7}, {7, 8},
                {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15},
        };
        */
        int[][] a = {
                {0, 1}, {2, 3}, {4, 5}, {6, 7},
                {0, 2}, {1, 3}, {4, 6}, {5, 7},
                {1, 2}, {5, 6}, {0, 4}, {3, 7},
                {1, 5}, {2, 6},
                {1, 4}, {3, 6},
                {2, 4}, {3, 5},
                {3, 4}
        };
        int [][] b = {
                {14, 15}, {13, 14}, {12, 13}, {11, 12}, {10, 11}, {9, 10}, {8, 9}, {7, 8}, {6, 7}, {5, 6}, {4, 5}, {3, 4}, {2, 3}, {1, 2}, {0, 1},
        };
        ArrayList<Integer> trialResults = new ArrayList<>();
        int trials = 0;
        Comparator lastComp= new Comparator(0,0);
        // Trials Loop
        while (trials < 100) {
            // Adds all comparisons to the current network
            ArrayList<Comparator> currentComparators = new ArrayList<>();
            ArrayList<Comparator> baseComparators = new ArrayList<>();
            for (int[] comp : a) {
                currentComparators.add(new Comparator(comp[0], comp[1]));
                baseComparators.add(new Comparator(comp[0], comp[1]));
            }
            // Declaring variables outside of loop for proper use
            ComparisonNetwork151 net;
            Set<String> badOutputs;
            int c = 0;
            int currentComp = 0;
            ComparisonNetwork151 testNet = new ComparisonNetwork151(8, currentComparators);
            System.out.println("test Sort, BadOutputs: " + testNet.getBadOutputs().size());
            boolean trialEnded = false;
            do {
                net = new ComparisonNetwork151(8, currentComparators); // Creates new network
                badOutputs = net.getBadOutputs(); // Gets the current bad outputs based on comparisons
                System.out.println("Current bad outputs: " + badOutputs.size());
                if (c == currentComparators.size() && badOutputs.size() != 0) { // If there are bad outputs and you are on the last comparison
                    trialResults.add(currentComparators.size()); // Add trial value to array for later calculation
                    trialEnded = true; // Set boolean to false so that trial will end
                } else {
                    // If there are still no bad outputs
                    if (badOutputs.size() == 0) {
                        System.out.println("#Comparators: " + currentComparators.size() + ", Removing comp#" + c);
                        lastComp = currentComparators.get(c);
                        currentComparators.remove(c); // Remove Comparison at spot C
                    } else {
                        if (c != 0) {
                            currentComparators.add(lastComp); // Add the previously removed comparison back to the list
                            c = -1;
                        }
                    }
                }
                System.out.println("Current Comp #:" + currentComparators.size());
                c++;
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            } while (!trialEnded);
            System.out.println("Trial " + trials + ": Completed");
            trials++;
        }
        // Average calculation
        int sum = 0;
        for (int t = 0; t < trialResults.size(); t++) {
            sum += trialResults.get(t);
        }
        System.out.println("The average number of comparisons needed was: " + sum/100);
    }
}

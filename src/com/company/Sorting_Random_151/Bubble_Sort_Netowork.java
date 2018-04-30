package com.company.Sorting_Random_151;

import com.company.Coles_Env.networks.Comparator;
import com.company.Coles_Env.networks.ComparisonNetwork;

import java.util.ArrayList;
import java.util.Set;

/**
 * Constructs a comparison network consisting of the first 32 comparisons of Green's sorting network
 * on 16 wires and outputs all unsorted binary outputs (there are 151 of them).
 *
 * @author Drue Coles
 */
public class Bubble_Sort_Netowork {


    public static void main(String[] args) {
        // Original Bubble sorting comparisons for the 16 wire sequence
        int[][] a = {
                {0, 1}, {2, 3}, {4, 5}, {6, 7},
                {8, 9}, {10, 11}, {12, 13}, {14, 15},
        };
        int [] trialResults = new int[100];
        int trials = 0;
        // Trials Loop
        while (trials < 100) {
            // Adds all comparisons to the current network
            ArrayList<Comparator> comparators = new ArrayList<>();
            for (int[] comp : a) {
                comparators.add(new Comparator(comp[0], comp[1]));
            }
            // Declaring variables outside of loop for proper use
            ComparisonNetwork net;
            Set<String> badOutputs;
            int c = 0;
            boolean trialEnded = false;
            do {
                net = new ComparisonNetwork(16, comparators); // Creates new network
                badOutputs = net.getBadOutputs(); // Gets the current bad outputs based on comparisons

                if (c == comparators.size() && badOutputs.size() != 0) { // If there are bad outputs and you are on the last comparison
                    trialResults[trials] = comparators.size(); // Add trial value to array for later calculation
                    trialEnded = true; // Set boolean to false so that trial will end
                } else {
                    // If there are still no bad outputs
                    if (badOutputs.size() == 0) {
                        comparators.remove(c);
                    }
                }
                c++;
            } while (!trialEnded);
            trials++;
        }
    }
}

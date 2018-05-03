package com.company.Main_Env_Networks;

import java.util.ArrayList;
import java.util.Set;

/**
 * Constructs a comparison network consisting of the first 32 comparisons of Green's sorting network
 * on 16 wires and outputs all unsorted binary outputs (there are 151 of them).
 *
 * @author Drue Coles
 */
public class sortingGreens32 {


    public static void main(String[] args) {

        // first 32 comparisons of Green's network on 16 wires
        int[][] a = {
                {0, 1}, {2, 3}, {4, 5}, {6, 7}, {8, 9}, {10, 11}, {12, 13}, {14, 15},
                {0, 2}, {4, 6}, {8, 10}, {12, 14},
                {1, 3}, {5, 7}, {9, 11}, {13, 15},
                {0, 4}, {1, 5}, {2, 6}, {3, 7},
                {8, 12}, {9, 13}, {10, 14}, {11, 15},
                {0, 8}, {1, 9}, {2, 10}, {3, 11}, {4, 12}, {5, 13}, {6, 14}, {7, 15},
                // New Comps
                {11, 14},
                {7, 13},
                {4, 5},
                {6, 8},
                {4, 9},
                {9, 10},
                {2, 11},
                {7, 15},
                {11, 13},
                {7, 14},
                {3, 12},
                {1, 3},
                {3, 6},
                {4, 9},
                {5, 9},
                {10, 13},
                {8, 15},
                {3, 4},
                {2, 13},
                {9, 10},
                {1, 2},
                {6, 9},
                {7, 15},
                {2, 11},
                {5, 6},
                {7, 8},
                {10, 12},
                {10, 14},
                {2, 3}
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
        System.out.println("0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        for (String out : badOutputs) {
            for (int k = 0; k < out.length(); k++) {
                System.out.print(out.charAt(k));
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println("Total Unsorted: " + badOutputs.size());
    }
}

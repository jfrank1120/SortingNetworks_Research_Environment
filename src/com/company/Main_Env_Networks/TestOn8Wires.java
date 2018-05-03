package com.company.Main_Env_Networks;

import java.util.ArrayList;
import java.util.Set;

/**
 * Creates a sorting network on 8 wires and obtains a list of unsorted binary outputs. The list
 * should be empty.
 * 
 * @author Jared Frank
 */
public class TestOn8Wires {

    public static void main(String[] args) {
        int[][] a = {
            {0, 1}, {2, 3}, {4, 5}, {6, 7},
            {0, 2}, {1, 3}, {4, 6}, {5, 7},
            {1, 2}, {5, 6}, {0, 4}, {3, 7},
            {1, 5}, {2, 6},
            {1, 4}, {3, 6},
            {2, 4}, {3, 5}, 
            {3, 4}
        };
        
        // convert to array list of comparators
        ArrayList<Comparator> comparators = new ArrayList<>();
        for (int[] comp : a) {
            comparators.add(new Comparator(comp[0], comp[1]));
        }

        ComparisonNetwork net = new ComparisonNetwork(8, comparators);
        Set<String> badOutputs = net.getBadOutputs();
        System.out.println(badOutputs.size());
    }
}

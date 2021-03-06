package com.company.Main_Env_Networks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Models a comparison network on wires index 0, 1, ..., n-1.
 *
 * @author Jared Frank
 */
public class ComparisonNetwork {

    // sequence of comparators defining this network
    private final ArrayList<Comparator> comparisons;

    // During construction of the network, a list of all unsorted binary outputs is created.
    private final Set<String> badOutputs = new HashSet<>();

    /**
     * Creates a new network on a specified number of wires with a specified sequence of
     * comparisons. T
     */
    public ComparisonNetwork(int numWires, ArrayList<Comparator> comparisons) {

        this.comparisons = (ArrayList<Comparator>) comparisons.clone();

        // Generate all binary inputs. Push each input through the network and check the output.
        // If the output is unsorted, update the sets of bad inputs and outputs.
        int n = (int) Math.pow(2, numWires);
        for (int i = 0; i < n; i++) {

            // Fill input array with bits in binary representation of i. Then apply the
            // network to this array and store the result in the output array.
            int[] input = new int[numWires];
            int m = i;
            for (int j = 0; j < numWires; j++) {
                input[j] = m % 2;
                m /= 2;
            }

            int[] output = feed(input);
            if (!isSorted(output)) {
                String str = "";
                for (int j : output) {
                    str += j;
                }
                badOutputs.add(str);
            }
        }
    }

    /**
     * Returns a copy of the bad (unsorted) outputs of this network.
     */
    public Set<String> getBadOutputs() {
        Set<String> set = new HashSet<>();
        badOutputs.forEach((out) -> {
            set.add(out);
        });
        return set;
    }

    /**
     * Returns the result of applying a given input to the network.
     */
    public final int[] feed(int[] input) {
        int[] output = input.clone();
        comparisons.forEach((c) -> {
            c.sort(output);
        });
        return output;
    }

    /**
     * Returns true if the elements of the give array are in sorted order.
     */
    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
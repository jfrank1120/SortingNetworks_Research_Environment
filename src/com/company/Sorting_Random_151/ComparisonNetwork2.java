package com.company.Sorting_Random_151;

import com.company.Coles_Env.networks.Comparator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class ComparisonNetwork2 {

    // sequence of comparators defining this network
    private final ArrayList<Comparator> comparisons;

    // During construction of the network, a list of all unsorted binary outputs is created.
    private final Set<String> badOutputs = new HashSet<>();

    /**
     * Creates a new network on a specified number of wires with a specified sequence of
     * comparisons. T
     */
    public ComparisonNetwork2(int numWires, ArrayList<Comparator> comparisons) {

        this.comparisons = (ArrayList<Comparator>) comparisons.clone();
        ArrayList<String> allBinary = generateBinary(16, "");
        ArrayList<String> sampleBinary = new ArrayList<>();

        for (int i = 0; i < sampleBinary.size(); i++) {
            int[] input = sampleBinary.get(i); // Convert string to integer array
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
    /**
     * Recursively generates all possible binary sequences for input size
     * @param bits - The size of the binary sequences in bits
     * @param current - The string from the previous iteration of the method
     * @return
     */
    public ArrayList<String> generateBinary(int bits, String current) {
        ArrayList<String> binaries = new ArrayList<>();
        if (current.length() == bits) {
            binaries.add(current);
            return binaries;
        }

        //pad a 0 and 1 in front of current;
        binaries.addAll(generateBinary(bits, "0" + current));
        binaries.addAll(generateBinary(bits, "1" + current));

        return binaries;
    }
}

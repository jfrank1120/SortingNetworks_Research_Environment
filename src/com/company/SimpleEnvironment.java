package com.company;

// Created by Jared Frank
// CompSci 495 - Independent Computer Science Research
// Under the supervision of Dr. Drue Coles

import java.util.HashSet;
import java.util.ArrayList;
public class SimpleEnvironment {
    String inputData = "";
    ArrayList<Integer> topWires = new ArrayList<>();
    ArrayList<Integer> bottomWires = new ArrayList<>();

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

    /**
     * Creates a comparison that is then used during the SortData method
     * @param numWires - The number of wires that are in the current network configuration
     * @param topWire - The wire location of the top of the comparison
     * @param bottomWire - The wire location of the bottom of the comparison
     * @return - Returns true if the comparison is created, else returns false
     */
    public boolean createComparison (int numWires, int topWire, int bottomWire) {
        if (topWire > numWires) {
            System.out.println("Error, top wire -" + topWire + " is not a possible wire");
        }
        else if (bottomWire < 0) {
            System.out.println("Error, bottom wire -" + bottomWire + " is not a possible wire");
        }
        else if (topWire == bottomWire) {
            //System.out.println("Error, cannot create a comparison on the same wire");
        }
        else {
            topWires.add(topWire);
            bottomWires.add(bottomWire);
            return true;
        }
        return false;
    }

    public ArrayList<int[]> createComparison(int numWires, int numComparisons) {
        ArrayList<int[]> allPossibleComparisons = new ArrayList<int[]>();
        for(int i = 0; i < numComparisons; i++) {
            for (int k = 0; k < numWires; k++) {
                for(int j = 0; j < numWires; j++) {
                    if (k != j) {
                        allPossibleComparisons.add(new int[]{k,j});
                    }
                }
            }
        }
    }

    /**
     * Sorts all of the input data
     * @param data - An arraylist with strings that are the data
     * @return - A hashset containing all of the values that are not fully sorted
     */
    public HashSet<String> sortData (ArrayList<String> data) {
        HashSet<String> unsortedDataSets = new HashSet<>();
        int i = 0;
        if (this.topWires.size() != this.bottomWires.size()) {
            System.out.println("Error, comparisons not properly formatted");
            return unsortedDataSets;
        }
        // Loops through all strings in the ArrayList
        while (i != data.size()) {
            // Loops through each character in the string
            for (int j = 0; j < data.get(i).length() - 1; j++) {
                // Loop through each comparison
                String setToCharArray = data.get(i);
                char[] currentStringCharArray = setToCharArray.toCharArray();
                for (int p = 0; p < this.topWires.size(); p++) {
                    if (topWires.get(p) > bottomWires.get(p)) {
                        int tempWire = topWires.get(p);
                        topWires.set(p, bottomWires.get(p));
                        bottomWires.set(p, tempWire);
                    }
                    if (currentStringCharArray[topWires.get(p)] < currentStringCharArray[bottomWires.get(p)]) {
                        // Swaps the two characters
                        char temp = currentStringCharArray[this.bottomWires.get(p)];
                        currentStringCharArray[this.bottomWires.get(p)] = currentStringCharArray[this.topWires.get(p)];
                        currentStringCharArray[this.topWires.get(p)] = temp;
                        String alteredSequence = new String(currentStringCharArray);
                        data.set(i, alteredSequence);
                    }
                }
            }

            boolean isSorted = true;
            for (int k = 0; k < data.get(i).length() - 1; k++) {
                if ((data.get(i).charAt(k) < data.get(i).charAt(k + 1))) {
                    isSorted = false;
                }
            }
            // If the string is not sorted
            if (!isSorted) {
                unsortedDataSets.add(data.get(i));
            }
            i++;
        }
        topWires.clear();
        bottomWires.clear();
        return unsortedDataSets;
    }
}

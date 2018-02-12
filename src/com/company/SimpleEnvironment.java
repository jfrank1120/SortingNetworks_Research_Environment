package com.company;

// Created by Jared Frank
// CompSci 495 - Independent Computer Science Research
// Under the supervision of Dr. Drue Coles

import java.util.HashSet;
import java.util.ArrayList;
public class SimpleEnvironment {
    String inputData = "";
    HashSet unsortedData = new HashSet<String>();
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
            System.out.println("Error, cannot create a comparison on the same wire");
        }
        else {
            topWires.add(topWire);
            bottomWires.add(bottomWire);
            return true;
        }
        return false;
    }

    /**
     * Sorts all of the input data
     * @param data - An arraylist with strings that are the data
     * @return - A hashset containing all of the values that are not fully sorted
     */
    public HashSet<String> sortData (ArrayList<String> data) {
        HashSet<String> unsortedDataSets = new HashSet<String>();
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
                System.out.println(data.get(i) + " Before set to charArray");
                String setToCharArray = data.get(i);
                char[] currentString = setToCharArray.toCharArray();
                System.out.println("After set to char array: " + currentString);
                for (int k = 0; k < this.topWires.size(); k++) {
                    if ((data.get(i).charAt(topWires.get(k)) < data.get(i).charAt(bottomWires.get(k)))) {
                        System.out.println("Current String: " + data.get(i));
                        // Swaps the two characters
                        System.out.println("Top Wire Location: " + topWires.get(k) + ", Bottom Wire Location: " + bottomWires.get(k));
                        System.out.println("Top Wire: " + data.get(i).charAt(topWires.get(k)) + ", Bottom Wire: " + data.get(i).charAt(bottomWires.get(k)));
                        System.out.println("Swapping");
                        char temp = currentString[this.bottomWires.get(k)];
                        currentString[this.bottomWires.get(k)] = currentString[this.topWires.get(k)];
                        System.out.println("After swap: " + currentString.toString());
                        currentString[this.topWires.get(k)] = temp;
                        System.out.println("String before set: " + currentString.toString());
                        data.set(i, currentString.toString());
                        System.out.println("New String: " + data.get(i));
                    }
                }
            }
            boolean isSorted = true;
            for (int k = 0; k < data.get(i).length() - 1; k++) {
                if ((data.get(i).charAt(k) < data.get(i).charAt(k + 1))) {
                    isSorted = false;
                }
            }
            if (!isSorted) {
                System.out.println("Adding: " + data.get(i));
                unsortedDataSets.add(data.get(i));
            }
            i++;
        }
        return unsortedDataSets;
    }

    /**
     * Returns the percentage of data that is unsorted in comparison to the total amount of data
     * @param unsortedData - The sequences that are not sorted after going through the randomized network
     * @param allData - All of the possible binary sequences for the number of wires
     * @return - The percentage that were sorted by the random network
     */
    public double percentageNotSorted(HashSet<String> unsortedData, ArrayList<String> allData) {
        System.out.println(unsortedData.size() + " / " + allData.size());
        return ((double) unsortedData.size() / (double) allData.size());
    }
}

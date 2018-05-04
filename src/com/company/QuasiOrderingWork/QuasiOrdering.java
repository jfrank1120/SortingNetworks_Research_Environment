package com.company.QuasiOrderingWork;
import java.util.*;

public class QuasiOrdering {
    private static boolean isASubset(int i, int j, int binSize) {
        boolean isASub = true;
        StringBuilder binaryStrBuilder = new StringBuilder(Integer.toBinaryString(i));
        while (binaryStrBuilder.length() != binSize) {
            binaryStrBuilder.insert(0, '0');
        }
        String binI = binaryStrBuilder.toString();
        StringBuilder binaryStrBuilder2 = new StringBuilder(Integer.toBinaryString(j));
        while (binaryStrBuilder2.length() != binSize) {
            binaryStrBuilder2.insert(0, '0');
        }
        String binJ = binaryStrBuilder2.toString();
        for (int p = 0; p < binJ.length(); p++) {
            if (binI.charAt(p) > binJ.charAt(p)) {
                isASub = false;
            }
        }
        return isASub;
    }
    public static HashSet<String> quasiSort(Binary_Collection inputData, int binSize) {
        HashSet<String> non_quasi_strings = new HashSet<>();
        // Bit comparison
        for (int k = 0; k < inputData.binaryStrings.size() - 1; ++k) {
            boolean isSorted = false;
            // Loops through all strings
            for (int i = 0; i < inputData.binaryStrings.get(k).length(); i++) {
                for (int j = i; j < inputData.binaryStrings.get(k).length(); j++) {
                    // Loops through characters within the string
                    int bitI = Character.getNumericValue(inputData.binaryStrings.get(k).charAt(i));
                    int bitJ = Character.getNumericValue(inputData.binaryStrings.get(k).charAt(j));
                    boolean isASub = isASubset(i, j, binSize);
                    if (bitI <= bitJ && isASub) {
                        System.out.println(bitI + "<=" + bitJ + ", " + i +" is a subset of " + j);
                        isSorted = true;
                    }
                    if (!isSorted) {
                        System.out.println("Adding: " + inputData.binaryStrings.get(i));
                        non_quasi_strings.add(inputData.binaryStrings.get(i));
                    }
                }

            }
        }
        return non_quasi_strings;
    }
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of Wires: ");
        int wire_num = in.nextInt();
        Binary_Collection allData = new Binary_Collection(wire_num);
        HashSet<String> unsortedString = quasiSort(allData, wire_num);
        Iterator<String> itr = unsortedString.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
        System.out.println("Size: " + unsortedString.size());
    }
}

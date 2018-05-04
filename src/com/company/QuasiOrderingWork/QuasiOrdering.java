package com.company.QuasiOrderingWork;
import java.util.*;

public class QuasiOrdering {
    public static HashSet<String> quasiSort(Binary_Collection inputData) {
        HashSet<String> non_quasi_strings = new HashSet<>();
        /*
        int[] zero = {1 , 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] one = {3, 5, 7, 9, 11, 13, 15};
        int[] two = {2, 3, 6, 7, 10, 11, 13, 15};
        int[] three = {5, 7};
        int[] four = {4, 5, 6, 7, 12, 13, 14, 15};
        int[] five = {7, 13, 15};
        int[] six = {7, 14, 15};
        int[] seven = {15};
        int[] eight = {9, 10, 11, 12, 13, 14, 15};
        int[] nine = {11, 13, 15};
        int[] ten = {11, 14, 15};
        int[] eleven = {15};
        int[] twelve = {13, 14, 15};
        int[] thirteen = {15};
        int[] fourteen = {15};
        int[] fifteen = {15};
        int[][] isASubsetOf = {zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen};
        */
        // Bit comparison
        for (int k = 0; k < inputData.binaryStrings.size() - 1; ++k) {
            boolean isSorted = true;
            // Loops through all strings
            for (int i = 0,j = 0; (inputData.binaryStrings.get(i).length() - (j + 1) > 0); ++j, ++i) {
                // Loops through characters within the string
                    int bitI = Character.getNumericValue(inputData.binaryStrings.get(k).charAt(inputData.binaryStrings.get(i).length() - (i)));
                    int bitJ = Character.getNumericValue(inputData.binaryStrings.get(k).charAt(inputData.binaryStrings.get(i).length() - (j + 1)));
                    boolean isASub = false;
                    String binI = Integer.toBinaryString(i);
                    String binJ = Integer.toBinaryString(j);
                    for (int p = binJ.length(); p > 0; p--) {
                        if (binI.charAt(p) > binJ.charAt(p)) {
                            isASub = false;
                        }
                    }
                    if (bitI < bitJ && !isASub) {
                        isSorted = false;
                        break;
                    }
                    if (!isSorted) {
                        System.out.println("Adding: " + inputData.binaryStrings.get(i));
                        non_quasi_strings.add(inputData.binaryStrings.get(i));
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
        /*
        for (String item : allData.binaryStrings) {
            System.out.println(item);
        }
        System.out.println("All Strings above ^^^");
        */
        HashSet<String> unsortedString = quasiSort(allData);
        Iterator<String> itr = unsortedString.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
        System.out.println("Size: " + unsortedString.size());
    }
}

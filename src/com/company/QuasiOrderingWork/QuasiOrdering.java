package com.company.QuasiOrderingWork;
import java.util.*;

public class QuasiOrdering {
    public static HashSet<String> quasiSort(Binary_Collection inputData) {
        HashSet<String> non_quasi_strings = new HashSet<>();

        // Bit comparison
        for(int k = 0; k < inputData.binaryStrings.size() - 1; ++k) {
            boolean isSorted = true;
            // Loops through all strings
            for (int i = 0; (i < inputData.binaryStrings.get(i).length()); ++i) {
                // Loops through characters within the string
                int bitI = Character.getNumericValue(inputData.binaryStrings.get(k).charAt(i));
                int bitJ = Character.getNumericValue(inputData.binaryStrings.get(k).charAt(j));
                if (var1 > var2 && var1 != var2) {
                    isSorted = false;
                    break;
                }
            }
            if (!isSorted) {
                System.out.println("Adding: " + inputData.binaryStrings.get(i));
                non_quasi_strings.add(inputData.binaryStrings.get(i));
            }
        }
        return non_quasi_strings;
    }
    public static void main(String[] args) {
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

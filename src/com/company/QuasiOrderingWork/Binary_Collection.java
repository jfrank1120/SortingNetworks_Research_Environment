package com.company.QuasiOrderingWork;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Binary_Collection {
    public ArrayList<String> binaryStrings;

    Binary_Collection(int num_wires) {
        //this.binaryStrings = generateBinary(num_wires, "");
        this.binaryStrings = generateOrderedBinary(num_wires);
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
    public ArrayList<String> generateOrderedBinary(int n) {
        ArrayList<String> binaryValues = new ArrayList<String>();
        for (int i = 0; i < Math.pow(2,n); i++) {
            StringBuilder binaryStrBuilder = new StringBuilder(Integer.toBinaryString(i));
            while (binaryStrBuilder.length() != n) {
                binaryStrBuilder.insert(0, '0');
            }
            binaryValues.add(binaryStrBuilder.toString());
        }
        return binaryValues;
    }
}

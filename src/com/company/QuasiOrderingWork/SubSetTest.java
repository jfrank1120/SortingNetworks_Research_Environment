package com.company.QuasiOrderingWork;

public class SubSetTest {
    public static void main(String[] args) {
        int binSize = 4;
        int i = 2;
        int j = 3;
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
        System.out.println(binI);
        System.out.println(binJ);
        for (int p = 0; p < binJ.length(); p++) {
            System.out.println(binI.charAt(p) + ": i, j: " + binJ.charAt(p));
            if (binI.charAt(p) > binJ.charAt(p)) {
                System.out.print(binI.charAt(p) + ">" + binJ.charAt(p));
                isASub = false;
            }
        }
        System.out.println(isASub);
    }
}

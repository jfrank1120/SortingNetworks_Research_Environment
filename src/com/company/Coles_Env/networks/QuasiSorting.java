package com.company.Coles_Env.networks;

import java.util.ArrayList;
import java.util.Set;

public class QuasiSorting {

    public static void main(String[] args) {
        ArrayList<Comparator> nullComparitors = new ArrayList<>();
        ComparisonNetwork net = new ComparisonNetwork(16, nullComparitors);
        Set<String> badOutputs = net.getBadOutputs();
        for (String out : badOutputs) {
            for (int k = 0; k < out.length(); k++) {
                System.out.print(out.charAt(k));
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println("Total Unsorted: " + badOutputs.size());
    }
}
package com.company.Main_Env_Networks;

import java.util.ArrayList;
import java.util.Random;

public class Buttom_Up_151 {
    public static void main(String[] args) {
        int trials = 0;
        ArrayList<Comparator> currentComparisons = new ArrayList<>();
        ArrayList<Integer> trialData = new ArrayList<>();
        double sumComps = 0;
        ComparisonNetwork151 netWork;
        while (trials < 50) {
            do {
                netWork = new ComparisonNetwork151(16, currentComparisons);
                currentComparisons.add(addRandomComparison());
            } while (!(netWork.getBadOutputs().size() == 0));
            sumComps += currentComparisons.size();
            System.out.println("Trail #" + trials);
            currentComparisons.clear();
            trials++;
        }
        System.out.println("Avg Number of comparisons needed: " + (sumComps/trials));
    }
    public static Comparator addRandomComparison() {
        ArrayList<Comparator> allPossibleComparators = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            for (int j = i + 1; j < 16; j++) {
                allPossibleComparators.add(new Comparator(i, j));
            }
        }
        // Select comparators at random
        //ArrayList<Comparator> listOfComparators = new ArrayList<>();
        Random rand = new Random();
        int k = rand.nextInt(allPossibleComparators.size());
        return allPossibleComparators.get(k);

    }
}

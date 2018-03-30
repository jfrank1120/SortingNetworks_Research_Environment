package com.company.Coles_Env.networks;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Monte Carlo simulation to calculate the expected number of unsorted binary outputs for a 16-wire
 * comparison network with 60 comparisons chosen independently at random.
 * 
 * @author Drue Coles
 */
public class RandomNetworks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of wires and size of network: ");
        int wires = in.nextInt();
        int size = in.nextInt();
        
        final int NUM_TRIALS = 100;
        int numUnsortedOutputs = 0;
        for (int i = 0; i < NUM_TRIALS; i++) {
            ComparisonNetwork net = getRandomNetwork(wires, size);
            numUnsortedOutputs += net.getBadOutputs().size();
        }
        
        int avg = numUnsortedOutputs / NUM_TRIALS;
        System.out.println("Average number of unsorted outputs: " + avg);        
    }
    
    /**
     * Returns a comparison network of a specified size on a specified number of wires. The
     * comparisons are chosen uniformly at random from the set of all possible comparisons.
     */
    private static ComparisonNetwork getRandomNetwork(int wires, int size) {
        // construct list of all possible comparators
        ArrayList<Comparator> allPossibleComparators = new ArrayList<>();
        for (int i = 0; i < wires; i++) {
            for (int j = i + 1; j < wires; j++) {
                allPossibleComparators.add(new Comparator(i, j));
            }
        }
        
        // select comparators at random
        ArrayList<Comparator> listOfComparators = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int k = rand.nextInt(allPossibleComparators.size());
            listOfComparators.add(allPossibleComparators.get(k));
        }
        
        return new ComparisonNetwork(wires, listOfComparators);
    }
}

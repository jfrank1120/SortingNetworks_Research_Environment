package com.company.Main_Env_Networks;

/**
 * Models a comparator attached to a pair of wires.
 *
 * @author Jared Frank
 */
public class Comparator {
    private final int top;
    private final int bot;

    public Comparator(int top, int bot) {
        this.top = top;
        this.bot = bot;
    }
    
    /**
     * Sorts the two values at (top, bot) of the given array. 
     */
    public void sort(int[] data) {
        if (data[top] > data[bot]) {
            int temp = data[top];
            data[top] = data[bot];
            data[bot] = temp;
        }
    }
}

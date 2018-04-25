package com.company.Old_Environment;

import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.Set;

public class Network {

    static int CURRENT_WIRE_NUM = 0;
    private ArrayList<Comparison> compList = null;

    public Network(int n) {
        compList = new ArrayList<Comparison>();
        CURRENT_WIRE_NUM = n;
    }

    public int getComparison(int wireNum, boolean top) {
        if (wireNum > CURRENT_WIRE_NUM) {
            return -1;
        } else {
            if (top) {
                return compList.get(wireNum).getTopWire();
            } else {
                return compList.get(wireNum).getBottomWire();
            }
        }
    }

    public void addComparison(Comparison comp) {
        compList.add(comp);
    }

    public void addComparison(int topWire, int bottomWire) {
        compList.add(new Comparison(topWire, bottomWire));
    }

    public void addComparison(int i, int topWire, int bottomWire) {
        compList.add(i, new Comparison(topWire, bottomWire));
    }

    public void addComparison(int i, Comparison comp) {
        compList.add(i, comp);
    }

    public int size() { return compList.size(); }

    public void sortOn(DataSequence wires) {
        this.compList.stream().forEach((comp) -> {
            comp.sortWires(wires);
        });
    }

    /**
     * Sorts all data through the current network configuration
     * @return - A set containing all of the sequences that were not fully sorted
     */
    public Set<DataSequence> sortOnAll() {
        HashSet<DataSequence> unsortedSequences = new HashSet<>();
        DataSequence sequence = new DataSequence(this.CURRENT_WIRE_NUM);
        sequence.step();
        while(!sequence.onlyZeros())
        {
            DataSequence test = sequence.clone();
            sortOn(test);
            if (!test.isSorted()){
                // Appends the unsorted list to the set
                unsortedSequences.add(test.clone());
            }
            sequence.step();
        }
        return unsortedSequences;
    }
    public Set<DataSequence> collectUnsortedDataSequences(Set<DataSequence> input) {
        if (input == null) {
            return sortOnAll();
        }

        HashSet<DataSequence> unsortedDataSequences = new HashSet<>();
        /*TODO - Should iterate over all of the sequences in the input DataSqeuence.
        For each sequence it should be cloned and then sorted.
        If the end result is not fully sorted then it should be added to unsortedDataSequences
        */
        return unsortedDataSequences;
    }
}

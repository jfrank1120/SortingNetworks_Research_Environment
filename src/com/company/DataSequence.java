package com.company;

public class DataSequence implements Comparable
{
    private final byte[] list;


    /**
     * Sets all data within the list to be 0's
     * @param n - The number of values within the list
     */
    public DataSequence(int n) {
        list = new byte[n];
        for (int i = 0; i < n; i++) {
            this.list[i] = 0;
        }
    }

    /**
     * Creates an identical copy of the list
     * @param list - The list to be cloned
     */
    public DataSequence(byte[] list) {
        this.list = list.clone();
    }

    /**
     * Sorts the two bits of the list, swapping them if it is necessary
     * @param n - position of the first bit
     * @param k - position of the second bit
     */
    public void sort(int n, int k) {
        if (this.list[n] == 1 && this.list[k] == 0) {
            this.list[n] = 0;
            this.list[k] = 1;
        }
    }

    /**
     * Checks to see that the current list is fully sorted
     * @return false if not fully sorted, else it returns true
     */
    public boolean isSorted() {
        for (int i = 0; i < this.list.length - 1; i++) {
            if (this.list[i] > this.list[i + 1]) {
                return false;
            }
        }
        return  true;
    }

    /**
     * Checks whether all of the values within the list are 0's
     * @return True if all values are 0, else returns false
     */
    public boolean onlyZeros() {
        for (int a = 0; a < this.list.length; a++) {
            if (this.list[a] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the input object is equal to the current list
     * @param o - The object to be compared
     * @return - True if the objects are identical, else false
     */
    @Override
    public boolean equals(Object o) { return compareTo(o) == 0;}

    @Override
    public int compareTo(Object o) {
        DataSequence otherSeq = (DataSequence) o;
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] < otherSeq.list[i]) {
                return -1;
            }
            if (this.list[i] > otherSeq.list[i]) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Creates a copy of the current list
     * @return - An identical copy of the current list
     */
    public DataSequence clone() { return new DataSequence(this.list);}

    /**
     * Changes the list by changing its value to an integer and then adding 1
     * to that value
     */
    public void step() {
        byte carryVal = 1;
        for (int i = this.list.length - 1; i >= 0 ; i--) {
            byte nextCarryVal = (byte) (carryVal * this.list[i]);
            this.list[i] = (byte) ((this.list[i] + carryVal) % 2);
            carryVal = nextCarryVal;
        }
    }
    /**
     * Returns the current list in string form
     * @return - The string equivalent of the current list
     */
    @Override
    public String toString() {
        String returnStr = "";
        for (byte i : this.list) {
            returnStr += i;
        }
        return returnStr;
    }
}

package com.company;


public class Comparison
{
    private int top;
    private int bottom;

    public Comparison(int top, int bottom)
    {
        // Makes sure that the input wire values match a top and bottom set
        if (top == bottom) {
            System.out.println("Error - Compairison cannot only be on one wire");
        } else {
            if (top > bottom) {
                this.top = top;
                this.bottom = bottom;
            } else {
                this.bottom = top;
                this.top = bottom;
            }
        }
    }

    public int getTopWire() { return this.top;};
    public int getBottomWire() { return this.bottom;};

    /**
     * Sets the top wire that the comparison will reside on
     * @param top - The wire for the comparison to be one
     */
    public void setTopWire(int top) {
        if (this.bottom != top) {
            if (top < bottom) {
                this.top = this.bottom;
                this.bottom = top;
            } else {
                this.top = top;
            }
        }
    }

    /**
     * Sets the value of the bottom location of the comparison
     * @param bot - The wire that the bottom of the comparison will reside on
     */
    public void setBottomWire(int bot) {
        if (this.top != bot) {
            if (bot > this.top) {
                this.bottom = this.top;
                this.top = bot;
            } else {
                this.bottom = bot;
            }
        }
    }

    public void sortWires(DataSequence wires) {
        wires.sort(this.top,this.bottom);
    }

    public void sortData(DataSequence wires) { wires.sort(this.top, this.bottom);}
}

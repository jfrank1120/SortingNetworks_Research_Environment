package com.company.Old_Environment;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Area for testing methods before implementation into the project
 * Jared Frank
 */
public class TestBench {
    public static void main(String[] args) {
        HashSet<String> testSet = new HashSet<String>();
        testSet.add("1234");
        testSet.add("5678");
        for (int i = 0; i < testSet.iterator().next().length() - 1; i++) {
            for (String temp : testSet) {
                System.out.print(temp.charAt(i));
            }
            System.out.println("Wire - " + i);
            System.out.println();
        }
        System.out.println("End of printing");
    }
}

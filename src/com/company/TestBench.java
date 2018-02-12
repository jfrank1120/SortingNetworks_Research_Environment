package com.company;

import java.util.ArrayList;

/**
 * Area for testing methods before implementation into the project
 * Jared Frank
 */
public class TestBench {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Kristin");
        char[] charTest = names.get(0).toCharArray();
        System.out.println(charTest.toString());
        String test = "WorkPlease";
        System.out.println(test);
        char[] charAry = test.toCharArray();
        System.out.println(charAry);
    }
}

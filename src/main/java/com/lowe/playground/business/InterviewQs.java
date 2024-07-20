package com.lowe.playground.business;

import java.text.Collator;
import java.util.Arrays;
import java.util.Stack;

public class InterviewQs {
//Minimum Cost of Equalizing an Array
    public static int findMinimumCost(int[] array) {
        // Sort the array to find the median
        Arrays.sort(array);
        int n = array.length;

        // Find the median
        int median;
        if (n % 2 == 0) {
            median = (array[n / 2 - 1] + array[n / 2]) / 2;
        } else {
            median = array[n / 2];
        }

        // Calculate the cost to convert all elements to the median
        int cost = 0;
        for (int num : array) {
            cost += Math.abs(num - median);
        }

        return cost;
    }

//Remove n number of duplicates from a string 
    public static String removeNDups(String entry, int dups){
        Stack<String> s = new Stack<String>();
        String[] c = entry.split("");
        for(int i = 0; i < c.length; i++){
            s.add(c[i]);
            if(s.size() >= dups){
                boolean equals = true;
                for(int x = s.size() - dups; x < s.size(); x++){
                    if(c[i] != s.pop()){
                        equals = false;
                    }
                }
                if(equals){
                    for(int x = 0; x < dups; x++){
                        s.pop();
                    }
                }
            }
        }
        return s.stream().toString();
    }
}
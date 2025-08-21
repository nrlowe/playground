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

//MinCore Problem
    public static int minCoresNeeded(int[] startTimes, int[] endTimes){
        int n = startTimes.length;
        int best = 0, current = 0;
        int s = 0, e = 0;
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        while(s < n){
            if(startTimes[s] < endTimes[e]){
                current++;
                best = Math.max(best, current);
                x++;
            } else {
                y++;
                current--;
            }
        }
        return best;
    }

//Stable Gene Problem
    public static int stableGene(String gene){
        char[] d = {'A', 'C', 'G', 'T'};
        int n = gene.length();
        int target = n / 4;
        int[] freq = new int[128];
        for(int i = 0; i < n, i++){
            freq[gene.charAt[i]]++;
        }
        int totalN = 0;
        int[] need = new int[128];
        for(char ch : d){
            need[ch] = Math.max(0, freq[ch] - target);
            totalN += need[ch];
        }
        int ans = n;
        int l = 0;
        for(int i = 0; i < n; i++){
            char c = gene.charAt(i);
            if(need[c] > 0){
                totalN--;
            }
            need[c]--;
            while(totalN == 0){
                ans = Math.min(ans, i - l + 1);
                char cl = gene.charAt(l++);
                need[cl]++;
                if(need[cl] > 0){
                    totalN++;
                }
            }
        }
        return ans;
    }
}
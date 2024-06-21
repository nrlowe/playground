package com.lowe.playground.business;

import java.util.ArrayList;
import java.util.List;

public class HackerRank {

    //Save-Humanity
    public void virusIndices(String p, String v) {
        char[] geneArr = p.toCharArray();
        char[] virusArr = v.toCharArray();
        List<Integer> returnIndices = new ArrayList<Integer>();
        boolean loop = true;
        int startingIndex = 0;
        while(loop){
            int virusIndex = 0;
            int mismatch = 0;
            int geneLength = virusArr.length;
            int lastIndex = geneArr.length - 1 - (virusArr.length/2);
            if(startingIndex == lastIndex){
                loop=false;
            }
            for(int i = startingIndex; i < geneArr.length; i++){
                if(geneLength > 0){
                    if(geneArr[i] != virusArr[virusIndex]){
                        mismatch++;
                        geneLength--;
                        virusIndex++;
                        if(mismatch > 1){
                            startingIndex++;
                            break;
                        }
                    } else {
                        if(geneLength - 1 <= 0 && mismatch > 1){
                            startingIndex++;
                            break;
                        } else if(virusIndex + 1 >= virusArr.length - 1 && mismatch <= 1 && startingIndex < lastIndex){
                            returnIndices.add(startingIndex);
                            startingIndex++;
                            break;
                        } else {
                            geneLength--;
                            virusIndex++;
                        }
                    }
                }
            }
        }
        if(returnIndices.size() > 0){
            String returnString = "";
            for(int i = 0; i < returnIndices.size(); i++){
                String x = Integer.toString(returnIndices.get(i));
                returnString = returnString + x + " ";
            }
            System.out.println(returnString.trim());
        } else {
            System.out.println("No Match!");
        }
    }

    //Save-Humanity Cleanup
    public void virusIndicesRefactor(String p, String v) {
        //check for indexs for each char in v and map where crossovers occur
    }
}   

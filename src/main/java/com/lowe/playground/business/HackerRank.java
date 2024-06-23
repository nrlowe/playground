package com.lowe.playground.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HackerRank {

//Save-Humanity - timeout error on larger test cases
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

//Shortest Path 2-D Array
    class Cell {
        int x, y, cost;
        Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    //Directions Up, right, down, left
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {-1, 0, 1, 0};

    public int shortestPath(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] minCost = new int[rowLength][colLength];

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparing(cell -> cell.cost));
        queue.offer(new Cell(0,0, grid[0][0]));
        minCost[0][0] = grid[0][0];
        while(!queue.isEmpty()){
            Cell currentCell = queue.poll();
            int currentx = currentCell.x;
            int currenty = currentCell.y;
            if(currentx == rowLength && currenty == colLength){
                return minCost[currentx][currenty];
            }
            for(int i = 0; i < 4; i++){
                int nextx = dx[i];
                int nexty = dy[i];

                if(nextx >= 0 && currentx < nextx && rowLength >= 0 && currenty < colLength){ 
                    int newCost = minCost[currentx][currenty] + grid[nextx][nexty];
                    if(newCost < minCost[nextx][nexty]){
                        minCost[nextx][nexty] = newCost;
                        queue.offer(new Cell(nextx, nexty, newCost));
                    }
                }
            }
        }
        return -1;
    }


}   

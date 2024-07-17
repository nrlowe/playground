package com.lowe.playground.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

//Number of Queen Moves
    public int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        //all directions up, up right, right, down right, down, down left, left, up left
        int[] dx = {0, 1, 0, 1, 0, -1, 0, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; 
        for(int i = 0; i < dx.length; i++){
            int xmove = dx[i];
            int ymove = dy[i];
        }
        return 0;
    }

//Climbing Leaderboard Problem
    public List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> returnList = new ArrayList<Integer>();
        ranked.stream().distinct().sorted().collect(Collectors.toList());
        for(int j = 0; j < player.size(); j++){
            int  i = 1;
            for(Integer score : ranked){
                if(player.get(j) >= score){
                   returnList.add(i); 
                   break;
                }
                i++;
            }
        }
        
        return returnList;
    }

//Organizing Containers - moving items to match in a container in n number of swaps
    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
        boolean possible = false;
        int containers = container.size();
        int columns = container.get(0).size();
        for(List<Integer> cont : container){

        }
        if (possible) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

    public static void containerSwap() {

    }

//Array Leap Game
    public boolean canWin(int leap, int[] game){
        boolean inGame = true;
        int index = 0;
        while(inGame){
            if(index + leap >= game.length || index + 1 >= game.length){
                return true;
            }
            if(index + leap < game.length){
                if(game[index + leap] == 0){
                    index = index + leap;
                }
            } else if (index + 1 < game.length){
                if(game[index + 1] == 0){
                    index = index + 1;
                }
            } else if(index - 1 >= 0){
                if(game[index - 1] == 0){
                    index = index - 1;
                }
            } else {
                inGame = false;
            }
        }
        return false;
    }

//Comparator Problem
    class Player{
        String name;
        int score;
        
        Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }

    public Player[] checker(Player[] players) {
        Player[] sortedArray = new Player[players.length];

        return sortedArray;
    }

//Student Priority Queue 
    class Student {
        int id;
        String name;
        double cgpa;

        public int getId(){
            return id;
        }

        public String getName(){
            return name;
        }

        public double getCGPA() {
            return cgpa;
        }
    }

    public List<Student> getStudents(List<String> events) {
        List<Student> returnList = new ArrayList<Student>();
        PriorityQueue<Student> pq = new PriorityQueue<Student>(Comparator.comparing(x -> x.getCGPA()));
        while(!pq.isEmpty()){

        }
        return returnList;
    }


}   

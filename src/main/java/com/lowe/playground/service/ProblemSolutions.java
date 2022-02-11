package com.lowe.playground.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.sun.source.tree.Tree;

public class ProblemSolutions {
	
	static class Node {
		private int data;
		
		public int getData() {
			return this.data;
		}
		
		public void setData(int data) {
			this.data = data;
		}	
	}
	
	//2.5 Sum Lists - (716) + (592) = 219 --- 617 + 295
	
	public int sumLists(LinkedList<Integer> a, LinkedList<Integer> b) {
		int returnValue = -1;
		
		return returnValue;
	}
	
	//2.6 Palindrome, linked list
	public boolean isPalindrome(LinkedList<String> a) {
		List<String> letters = new ArrayList<String>();
		for(String n : a) {
			letters.add(n);
		}
		int endPoint = a.size() - 1;
		for(int i = 0; i <= endPoint/2; i++) {
			if(!letters.get(i).equals(letters.get(endPoint))) {
				return false;
			}
			endPoint--;
		}
		return true;
	}
	
	//2.7 Intersection - Linked List
	public boolean frindIntersection(LinkedList<Node> a, LinkedList<Node> b) {
		HashMap<Integer, Node> hash = new HashMap<Integer, Node>();
		for(Node node : a) {
			hash.put(node.data, node);
		}
		for(Node node : b) {
			if(hash.containsKey(node.data)) {
				if(node.equals(hash.get(node.data))) {
					return true;
				}
			}
		}
		return false;
	}
	
	//2.8 Loop Detection / Linked List
	public boolean isLinkedListLooped(LinkedList<Node> a) {
		HashMap<Integer, Node> hash = new HashMap<Integer, Node>();
		for(Node node : a) {
			if(hash.containsKey(node.data)) {
				return true;
			} else {
				hash.put(node.data, node);
			}
		}
		return false;
	}
	
	//Stacks and Queues
	
	//3.1 Single Array to implement 3 stacks
	
	
	//3.2 Stack that has min function that runs 0(n)
	
	//3.3 Stack of plates, once certain threshold is reached, new stack is created - pop and push perform as if single stack
	// part 2 -> popAt(index) function on specific stack as opposed to treating it like a single stack
	
	//3.4 Queue that implements 2 stacks
	
	//3.5 Sort Stack - have a minimum values at top , can only use another stack as helper, no other data structure
	
	//3.6 FIFO dog and cat stack, can request which animal
	
	//Moderate
	
	//16.1 Number Swapper
	public void swapNumbers(int a, int b) {
		int diff = a + b;
		b = diff - b;
		a = diff - a;
	}
	
	//16.2 Word Frequencies // trie graph??
	public void wordFrequency(String[] book) {
		HashMap<String, Integer> words = new HashMap<String, Integer>(); 
		for(String w : book) {
			if(words.containsKey(w)) {
				int count = words.get(w);
				count++;
				words.put(w, count);
			} else {
				words.put(w, 1);
			}
		}
		
	}
	
	//16.3 Intersection
	public static class linePoint{
		public int y;
		public int x;
		
		public int getY() {
			return this.y;
		}
		
		public void setY(int a) {
			this.y = a;
		}	
		
		public int getX() {
			return this.x;
		}
		
		public void setX(int b) {
			this.x = b;
		}	
		
	}
	public boolean isLineInterSection(linePoint start1, linePoint end1, linePoint start2, linePoint end2) {
		double slope1 = 0;
		double slope2 = 0;
		int y1 = end1.getY() - start1.getY();
		int x1 = end1.getX() - start1.getX();
		int y2 = end2.getY() - start2.getY();
		int x2 = end2.getX() - start2.getX();
		if(y1 != 0 || x1 != 0) {
			slope1 = y1/x1;
		}
		if(y2 != 0 || x2 != 0) {
			slope2 = y2/x2;
		}
		double yIntercept = 0;
		return false;
	}
	
	//16.4 Tic-Tac Win
	public boolean isTicTacWin(String[][] board) {
		//check middle, and top left and bottom right
		//is it a 3 by 3?
		//check top left, top right for diagonal lines - then get middle lines vertical/horizontal 
		if(tttColumn(board, 0)) {
			return true;
		}
		
		if(tttRow(board, 0)) {
			return true;
		}
		
		if(tttDiagonal(board, 0, 0, true)) {
			return true;
		}
		
		return false;
	}
	
	public boolean tttColumn(String[][] board, int x) {
		String value = board[0][x];
		for(int y = 1; y < board.length; y++) {
			String currentValue = board[y][x];
			if(!value.equals(currentValue) && x < board.length) {
				x++;
				y = 0;
				value = board[y][x];
			} else if(y == board.length - 1 && value.equals(currentValue)) {
				return true;
			}
		}
		 return false;
	}
	
	public boolean tttRow(String[][] board, int y) {
		String value = board[y][0];
		for(int x = 1; x < board.length; x++) {
			String currentValue = board[y][x];
			if(!value.equals(currentValue) && y < board.length) {
				y++;
				x = 0;
				value = board[y][x];
			} else if(x == board.length - 1 && value.equals(currentValue)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean tttDiagonal(String[][] board, int y, int x, boolean firstPass) {
		String value = board[y][x];
		if(firstPass) {
			while(firstPass) {
				x++;
				y++;
				String currentValue = board[y][x]; 
				if(!value.equals(currentValue)) {
					firstPass = false;
					boolean sP = tttDiagonal(board, board.length - 1, 0, firstPass);
					return sP;
				} else if(x == board.length - 1 && value.equals(currentValue)) {
					return true;
				}
			}
		} else {
			boolean secondPass = true;
			while(secondPass) {
				y--;
				x++;
				String currentValue = board[y][x]; 
				if(!value.equals(currentValue)) {
					break;
				} else if(x == board.length - 1 && value.equals(currentValue)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//16.5 Factorial Zeros
	
	//16.6 Smallest Difference
	public int smallestDifference(int[] a, int[] b) {
		int min = Integer.MAX_VALUE;
		Arrays.sort(a);
		Arrays.sort(b);
		int indexA = 0;
		int indexB = 0;
		while(indexA < a.length && indexB < b.length) {
			int diff = Math.abs(a[indexA] - b[indexB]);
			min = Math.min(min, diff);
			if(a[indexA] < b[indexB]) {
				indexA++;
			} else {
				indexB++;
			}
		}
		return min;
	}
	
	//16.10 Living People
	public static class People{
		public int birth;
		public int death;
		
		public int getBirth() {
			return this.birth;
		}
		
		public void setBirth(int a) {
			this.birth = a;
		}	
		
		public int getDeath() {
			return this.death;
		}
		
		public void setDeath(int b) {
			this.death = b;
		}
		
	}
	public int mostALive(List<People> people) {
		int peopleCount = 0;
		int maxYear = 0;
		int maxAlive = 0;
		int[] births = new int[people.size()];
		int[] deaths = new int[people.size()];
		int x = 0;
		for(People peep : people) {
			births[x] = peep.birth;
			deaths[x] = peep.death;
			x++;
		}
		Arrays.sort(births);
		Arrays.sort(deaths);
		int bIndex = 0;
		int dIndex = 0;
		while(dIndex < deaths.length && bIndex < births.length) {
			if(births[bIndex] <= deaths[dIndex]) {
				peopleCount++;
				if(peopleCount > maxAlive) {
					maxAlive = peopleCount;
					maxYear = births[bIndex];
				}
				bIndex++;
			} else {
				peopleCount--;
				dIndex++;
			}
		}
		return maxYear;
	}
	
	//16.11
	public HashSet<Integer> allLengths(int k, int shorter, int longer){
		HashSet<Integer> lengths = new HashSet<Integer>();
		HashSet<String> visited = new HashSet<String>();
		getAllLengths(k, 0, shorter, longer, lengths, visited);
		return lengths;
	}
	
	public void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited) {
		if(k == 0) {
			lengths.add(total);
			return;
		}
		String key = k + " " + total;
		if(visited.contains(key)) {
			return;
		}
		getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
		getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);
		visited.add(key);
	}
	
	//16.14
	
	//16.16
	
	//16.17
	public int contiguousSequenceMax(int[] a){
		int maxSum = Integer.MIN_VALUE;
		Queue<Integer> nums = new LinkedList<Integer>();
		for(Integer x : a) {
			nums.add(x);
		}
		int current = 0;
		int next = 0;
		int returnMax = 0;
		while(!nums.isEmpty()) {
			current = nums.remove();
			if(current > 0 && maxSum + current > 0) {
				maxSum += current;
				if(!nums.isEmpty()) {
					next = nums.remove();
				}
				if(next + current <= 0) {
					maxSum = 0;
				} else {
					maxSum += next;
				}
			} 
			if(maxSum > returnMax) {
				returnMax = maxSum;
			}
		}
		
		return returnMax;
	}
	
	public int simpleSolution(int[] a) {
		int maxSum = 0;
		int sum = 0;
		for(int x : a) {
			sum += x;
			if(sum > maxSum) {
				maxSum = sum;
			} else {
				sum = 0;
			}
		}
		return maxSum;
	}
	
	//17.2
	public int[] shuffle(int[] cards) {
		int[] newDeck = new int[cards.length];
		for(int card : cards) {
			addNewCard(newDeck, card);
		}
		return newDeck;
	}
	
	public int perfectNumberGenerator() {
		return (int)(Math.random() * 53) - 1; //1-53 since zero is first index subtract 1
	}
	
	public void addNewCard(int[] newDeck, int card) {
		int newValue = perfectNumberGenerator();
		if(newDeck[newValue] == 0) {
			newDeck[newValue] = card;
		} else {
			addNewCard(newDeck, card);
		}
		
	}
	
	//17.6
	public int countNumberTwos(int n) {
		return 0;
	}
	
	//17.12
	static class BiNode {
	    int value;
	    BiNode left;
	    BiNode right;

	    BiNode(int value) {
	        this.value = value;
	        right = null;
	        left = null;
	    }
	}
	
	public LinkedList<Integer> biNode(BiNode biNode){
		LinkedList<Integer> returnList = new LinkedList<Integer>();
		checkNodes(biNode, returnList);
		return returnList;
	}
	
	public void checkNodes(BiNode n, LinkedList<Integer> returnList) {
		if(n == null) {
			return;
		}
		checkNodes(n.left, returnList);
		checkNodes(n.right, returnList);
		returnList.add(n.value);
	}
	
	//17.15
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

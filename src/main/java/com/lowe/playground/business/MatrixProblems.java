package com.lowe.playground.business;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixProblems {
	class CustomNode{
		
		int col;
		int row;
		int steps;
		
		CustomNode(int y, int x, int step){
			this.col = y;
			this.row = x;
			this.steps = step;
		}
	    
	}
	public int findDestination(char[][] grid) {
		CustomNode source = findSourceNode(grid);
		boolean[][] flags = new boolean[grid.length][grid[0].length];
		return matrixBFS(flags, grid, source);
	}
	
	public int matrixBFS(boolean[][] flags, char[][] grid, CustomNode source) {
		Queue<CustomNode> queue = new LinkedList<CustomNode>();
		queue.add(source);
		while(!queue.isEmpty()) {
			CustomNode x = queue.remove();
			flags[x.col][x.row] = true;
			char nodeValue = grid[x.col][x.row];
			if(nodeValue == '*' || nodeValue == 's') {
				if(x.col-- >= 0) {
					if(!flags[x.col--][x.row]) {
						queue.add(new CustomNode(x.col-- , x.row, x.steps++));
					}
				}
				if(x.row++ < grid[0].length) {
					if(!flags[x.col][x.row++]) {
						queue.add(new CustomNode(x.col , x.row++, x.steps++));
					}
				}
				if(x.col++ < grid.length) {
					if(!flags[x.col++][x.row]) {
						queue.add(new CustomNode(x.col-- , x.row, x.steps++));
					}
				}
				if(x.row-- >= 0) {
					if(!flags[x.col][x.row--]) {
						queue.add(new CustomNode(x.col , x.row--, x.steps++));
					}
				}
			} else if(nodeValue == 'd') {
				return x.steps;
			}
		}
		
		return -1;
	}
	
	public CustomNode findSourceNode(char[][] grid) {
		CustomNode source = new CustomNode(-1, -1, 0);
		boolean found = false;
		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length; x++) {
				if(grid[y][x] == 's') {
					source.col = y;
					source.row = x;
					found = true;
					break;
				}
			}
			if(found) {
				break;
			}
		}
		return source;
	}
}

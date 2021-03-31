package com.lowe.playground.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuickSortBusiness {
	
	public List<Integer> lastIndexSort(String csvNumbers){
		List<Integer> sortedList = new ArrayList<>();
		int[] unsortedArray = convertCSVString(csvNumbers);
		
		return sortedList;
	}
	
	private int[] convertCSVString(String csvNumbers) {
		String[] stringArray = csvNumbers.trim().split(",");
		int[] results = new int[]{stringArray.length};
		for(int i = 0; i < results.length; i++) {
			results[i] = Integer.parseInt(stringArray[i]); 
		}
		return results;
	}
}

package com.lowe.playground.business;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuickSortBusiness {
	
	public List<Integer> lastIndexSort(String csvNumbers){
		List<Integer> sortedList = new ArrayList<>();
		int[] unsortedArray = convertCSVString(csvNumbers);
		quickSort(unsortedArray, 0, unsortedArray.length - 1);
		return sortedList;
	}
	
	private void quickSort(int[] array, int lowIndex, int highIndex) {
		if(lowIndex < highIndex) {
			int splitIndex = lastIndexPivot(array, lowIndex, highIndex);
			quickSort(array, lowIndex, splitIndex - 1);
			quickSort(array, splitIndex + 1, highIndex);
		}
	}
	
	private int lastIndexPivot(int[] array, int lowIndex, int highIndex) {
		int pivot = array[highIndex];
		int lag = lowIndex - 1;
		for(int i = lowIndex; i <= array.length - 1; i++) {
			if(array[i] < pivot) {
				lag++;
				swap(array, lag, i);
			}
		}
		lag++;
		swap(array, lag, highIndex);
		return lag;
	}
	
	private void swap(int[] array, int indexOne, int indexTwo) {
		int temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
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

package com.lowe.playground.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowe.playground.business.QuickSortBusiness;
import com.lowe.playground.entity.AlgorhythmResponseEntity;

@Service
public class AlgorhythmService {
	
	@Autowired
	QuickSortBusiness qsBusiness;
	
	public AlgorhythmResponseEntity lastIndexQuickSort(String csvNumbers) {
		AlgorhythmResponseEntity response = new AlgorhythmResponseEntity();
		try {
			response.setResponseArray(qsBusiness.lastIndexSort(csvNumbers));
		} catch (Exception e) {
			response.setError(true);
			response.setErrorMessage("Error running QuickSort on Last Index: " + e);
		}
		return response;		
	}
}

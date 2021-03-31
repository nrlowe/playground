package com.lowe.playground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowe.playground.business.QuickSortBusiness;
import com.lowe.playground.entity.AlgorhythmResponseEntity;
import com.lowe.playground.service.AlgorhythmService;

@RestController
public class QuickSortController {
	
	@Autowired
	AlgorhythmService algorhythmService;
	
	@RequestMapping(value = "/lastIndexQuickSort", method = RequestMethod.GET)
	public AlgorhythmResponseEntity lastIndexQuickSort(@RequestParam(value = "quickSortValue", required = true) String csvNumbers){
		AlgorhythmResponseEntity response = new AlgorhythmResponseEntity();
		response = algorhythmService.lastIndexQuickSort(csvNumbers);
		return response;
	}
	
	@RequestMapping(value = "/firstIndexQuickSort", method = RequestMethod.GET)
	public AlgorhythmResponseEntity firstIndexQuickSort(@RequestParam(value = "quickSortValue", required = true) String csvNumbers){
		AlgorhythmResponseEntity response = new AlgorhythmResponseEntity();
		//response = algorhythmService.lastIndexQuickSort(csvNumbers);
		return response;
	}
}

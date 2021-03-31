package com.lowe.playground.entity;

import java.util.List;

public class AlgorhythmResponseEntity {
	private boolean error = false;
	private String errorMessage;
	private List<Integer> responseArray;
	
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
	

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Integer> getResponseArray() {
		return responseArray;
	}

	public void setResponseArray(List<Integer> responseArray) {
		this.responseArray = responseArray;
	}
	
	
	
	
}

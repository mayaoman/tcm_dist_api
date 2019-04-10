package com.yention.tcm.api.domains;
import lombok.Data;

@Data
public class ResultResponse<T> {
	private boolean result;
	private String message;
	private T data;

	public ResultResponse(T data) {
		this.result = true;
		this.data = data;
	}

	public ResultResponse(boolean result, String message) {
		this.result = result;
		this.message = message;
	}
}
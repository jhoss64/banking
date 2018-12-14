package com.ads2018II.banking.application.dto.common;

import java.util.List;

public class ResponseQueryDto<T> {
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}

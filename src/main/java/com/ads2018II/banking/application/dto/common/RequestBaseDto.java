package com.ads2018II.banking.application.dto.common;

import com.ads2018II.banking.application.enum_common.RequestBodyType;

public class RequestBaseDto {
	protected RequestBodyType requestBodyType;

	public RequestBodyType getRequestBodyType() {
		return requestBodyType;
	}

	public void setRequestBodyType(RequestBodyType requestBodyType) {
		this.requestBodyType = requestBodyType;
	}
		
}

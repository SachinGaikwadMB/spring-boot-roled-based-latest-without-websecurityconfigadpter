package com.mb.api.business.exception;

import com.mb.api.business.constanst.StatusCode;

public class CustomException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	private  final com.mb.api.business.constanst.StatusCode code;
	
	
	public CustomException(String meassage, StatusCode code)
	{
		super(meassage);
		this.code = code;
		
	}

	public StatusCode getCode()
	{
		return code;
	}
	
	
	
	
	
}

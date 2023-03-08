package com.mb.api.business.constanst;

public enum StatusCode
{
	
	INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
	
	USER_NOT_FOUND(600, "user Not Found"),
	USER_ALREADY_EXIST(601, "user Already Exist"),
	CATEGORY_ALREADY_EXIST(602, "Category Already Exist"),
	NO_DATA_FOUND(603, "No Data Found!")
	;
	
	private final int code;
	private final String reasonPhrase;
	
	private StatusCode(int code, String reasonPhrase)
	{
		this.code = code;
		this.reasonPhrase = reasonPhrase;
	}

	public int getCode()
	{
		return code;
	}

	public String getReasonPhrase()
	{
		return reasonPhrase;
	}
	
	
}

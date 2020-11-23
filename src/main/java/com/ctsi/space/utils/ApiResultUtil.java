package com.ctsi.space.utils;

import com.ctsi.space.domain.dto.ApiResult;

public class ApiResultUtil {

	public final static Integer OK = 200;
	public final static Integer ERR = 401;
	
	public static <T> ApiResult<T> createSuccessApiResult(String msg, T data) {
		ApiResult<T> result = new ApiResult<>();
		result.setCode(OK);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	public static <T> ApiResult<T> createErrorApiResult(String msg) {
		return createErrorApiResult(msg, null);
	}
	
	public static <T> ApiResult<T> createErrorApiResult(String msg, T data) {
		ApiResult<T> result = new ApiResult<T>();
		result.setCode(ERR);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	
	public static <T> ApiResult<T> createErrorApiResult(String msg, int code, T data){
		ApiResult<T> result = new ApiResult<>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
}

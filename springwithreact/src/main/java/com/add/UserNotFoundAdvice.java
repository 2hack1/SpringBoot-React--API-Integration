package com.add;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNotFoundAdvice {

	
//	@ExceptionHandler(UserNotFoundException.class)
//	@RequestBody
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public Map<String,String> exceptionHandler(UserNotFoundException exception){
//		Map<String,String> errorMap=new HashMap<>();
//		errorMap.put("errorMessage",exception.getMessage());
//		return errorMap;
//	}
}

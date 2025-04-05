package com.FirstProject.EmployeeDetails.exception;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException e)
	{
		Map<String, String> errors = new HashMap<String, String>();
		e.getBindingResult().getFieldErrors().forEach(error->
		errors.put(error.getField(), error.getDefaultMessage())
				);
		return errors;
	}
}

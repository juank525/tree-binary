package com.motechnologies.treebinary.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.motechnologies.treebinary.model.ErrorResponse;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({ TreeException.class })
	@ResponseBody
	ResponseEntity<Object> handleBusinessException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}

}
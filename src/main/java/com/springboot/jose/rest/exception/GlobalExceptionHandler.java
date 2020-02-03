package com.springboot.jose.rest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ApiError> handleException(GlobalNotFoundException ine) {
		ApiError errorResponse = new ApiError(HttpStatus.NOT_FOUND, ine);
		errorResponse.setMessage(ine.getMessage());
		return new ResponseEntity<ApiError>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ApiError> handleException(Exception ex) {
		ApiError errorResponse = new ApiError(HttpStatus.BAD_REQUEST, ex);
		return new ResponseEntity<ApiError>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError errorResponse = new ApiError(status, ex);
		return ResponseEntity.status(status).headers(headers).body(errorResponse);
	}


}

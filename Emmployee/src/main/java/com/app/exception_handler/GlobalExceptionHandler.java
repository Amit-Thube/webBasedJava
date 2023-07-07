package com.app.exception_handler;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exception.ResourceNotFoundException;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
	{
		
		Map<String, String> map= e.getFieldErrors().stream().collect(Collectors.toMap(f->f.getField(), f->f.getDefaultMessage()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		System.out.println("handle res not found"+e);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new com.app.dto.ApiResponse(e.getMessage()));
	}
}

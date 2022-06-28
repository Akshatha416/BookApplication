package com.example.demo.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.DataNotFoundException;
import com.example.demo.error.ErrorMessages;

@ControllerAdvice
public class ExceptionHandlings {
	
	@ExceptionHandler(DataNotFoundException.class)
	 public ResponseEntity<ErrorMessages> handleException(DataNotFoundException e){
		
		return new ResponseEntity<ErrorMessages>(new ErrorMessages(e.getMessage(),
				LocalDateTime.now(),
				e.getClass().toString()),HttpStatus.OK);
	}
	

}

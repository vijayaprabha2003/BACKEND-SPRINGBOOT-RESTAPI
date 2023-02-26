package com.viji.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.viji.exception.FactNotfoundException;

@CrossOrigin(origins = "https://localhost:3000")
@ControllerAdvice
public class FactExceptionController
{
	@ExceptionHandler(value = FactNotfoundException.class)
	public ResponseEntity<Object> exception(FactNotfoundException exception)
	{
		return new ResponseEntity<>("Fact not found", HttpStatus.NOT_FOUND);
	}
}

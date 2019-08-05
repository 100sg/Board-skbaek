package com.skbaek.board.exception;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<?> noResultExceptionHandler(NoResultException e) {
		logger.error(e.getMessage());
		return ResponseEntity.noContent().build();
	}
}

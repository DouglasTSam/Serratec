package org.serratec.finalproject.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsControllers {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> ResourceNotFound(ResourceNotFoundException exception) {
		String msg = String.format("The ID %d not found", exception.getId());
		return ResponseEntity.notFound().header("Erro - msg", msg).header("Erro - code", "RESOURCE_NOT_FOUND")
				.header("Erro - value", exception.getId().toString()).build();

	}

	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(NotAllowedException.class)
	public ResponseEntity<String> NotAllowed(NotAllowedException exception) {
		String msg = exception.getMessage();
		return ResponseEntity.status(406).header("Erro", msg).header("Code", " operation is not possible").build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errorsOcurred = new HashMap<>();
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		for (ObjectError error : errors) {
			String attribute = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errorsOcurred.put(attribute, message);
		}
		return errorsOcurred;

	}
}

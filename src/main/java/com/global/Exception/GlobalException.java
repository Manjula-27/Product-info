package com.global.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	 @ResponseStatus(code=HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
	    protected Map<String, String> handleMethodArgNotValidException(MethodArgumentNotValidException ex) {

		 Map<String, String> errorMessage = new HashMap<String, String>();
		 
		 List<FieldError> res =ex.getBindingResult().getFieldErrors();
		 for(FieldError obj: res) {
			 errorMessage.put(obj.getField(), obj.getDefaultMessage());
		 }
		return errorMessage;
	      

	       
	    }

}

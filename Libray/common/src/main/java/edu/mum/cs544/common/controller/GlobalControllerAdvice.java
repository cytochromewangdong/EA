package edu.mum.cs544.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.cs544.common.dto.ResultDto;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.OK) // BAD_REQUEST, TO BE compatible
	@ResponseBody
	public ResultDto handleParameterException(MethodArgumentNotValidException exception) {
		// DomainErrors errors = new DomainErrors();
		// errors.setErrorType("invalidException");
		// exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
		// errors.addError(new DomainError(messageAccessor.getMessage(fieldError)));
		// });
		// exception.getBindingResult().getGlobalErrors().forEach(err -> {
		// errors.addError(new DomainError(messageAccessor.getMessage(err)));
		// });
		// return errors;
		return ResultDto.DEFAULT_FAIL_RESULT;
	}
}

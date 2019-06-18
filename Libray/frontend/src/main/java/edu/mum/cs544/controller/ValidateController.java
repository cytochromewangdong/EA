package edu.mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs544.common.dto.ResultDto;
import edu.mum.cs544.service.ValidateService;

@RestController
@RequestMapping("/validate")
public class ValidateController {

	@Autowired
	private ValidateService validateService;
	
	@RequestMapping("/checkEmailDuplicate/{email}")
	public ResultDto validateEmailDuplicate(@PathVariable String email)
	{
		return validateService.validateEmailDuplicate(email);
	}
}

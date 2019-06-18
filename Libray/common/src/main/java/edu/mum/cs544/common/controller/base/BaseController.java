package edu.mum.cs544.common.controller.base;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs544.common.service.UserService;

public abstract class BaseController {
	@Autowired
	protected UserService userService;

}

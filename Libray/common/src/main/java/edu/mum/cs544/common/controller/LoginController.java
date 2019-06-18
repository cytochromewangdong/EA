package edu.mum.cs544.common.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs544.common.controller.base.BaseController;
import edu.mum.cs544.common.dto.OpenId;
import edu.mum.cs544.common.dto.UserNamePassword;

@RestController
public class LoginController extends BaseController {

	@PostMapping("/login")
	public OpenId login(@RequestBody UserNamePassword userNamePassword) {
		return userService.authenticateUser(userNamePassword);
	}
}

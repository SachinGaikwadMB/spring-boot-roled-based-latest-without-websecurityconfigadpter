package com.mb.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mb.api.business.service.UserService;
import com.mb.api.web.Model.UserModel;
import static com.mb.api.business.constanst.GenericConstant.AUTH;
import static com.mb.api.business.constanst.GenericConstant.SIGNUP_USERS;
import static com.mb.api.business.constanst.GenericConstant.SIGNUP_ADMINS;


@RestController
@RequestMapping(AUTH)
public class UserController extends BaseController
{
	@Autowired
	private UserService userService;
	
	@PostMapping(SIGNUP_USERS)
	public ResponseEntity<String> saveUser(@RequestBody UserModel userModel) {
		return new ResponseEntity<>(userService.saveUser(userModel), HttpStatus.CREATED);
	}
	
	@PostMapping(SIGNUP_ADMINS)
	public ResponseEntity<String> saveAdmin(@RequestBody UserModel userModel) {
		return new ResponseEntity<>(userService.saveAdmin(userModel), HttpStatus.CREATED);
	}
}

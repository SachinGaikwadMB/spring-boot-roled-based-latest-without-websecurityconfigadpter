package com.mb.api.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.mb.api.business.constanst.GenericConstant.TEST;

@RequestMapping(TEST)
public class TestController extends BaseController
{
	@GetMapping
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Hello I'm from test controller", HttpStatus.OK);
	}
}

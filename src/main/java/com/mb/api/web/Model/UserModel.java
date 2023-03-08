package com.mb.api.web.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel
{
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
}

package com.mb.api.business.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mb.api.business.constanst.ERole;
import com.mb.api.business.constanst.StatusCode;
import com.mb.api.business.exception.CustomException;
import com.mb.api.persistance.entity.User;
import com.mb.api.persistance.repository.RoleRepository;
import com.mb.api.persistance.repository.UserRepository;
import com.mb.api.web.Model.LoginModel;
import com.mb.api.web.Model.UserModel;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public String saveUser(UserModel userModel) throws CustomException
	{
		
		
		if(userRepository.existsByEmail(userModel.getEmail())) {
			throw new CustomException("User Already Exist ! Try with another email.", StatusCode.USER_ALREADY_EXIST);
		}
		
		User user = modelMapper.map(userModel, User.class);
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		user.setRoles(Arrays.asList(roleRepository.findByRoleName(ERole.ROLE_USER)));
		try
		{
			userRepository.save(user);
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}
		
			
		return  "User registered successfully !";
	}


	@Override
	public String saveAdmin(UserModel userModel) throws CustomException
	{

		if(userRepository.existsByEmail(userModel.getEmail())) {
			throw new CustomException("Admin Already Exist ! Try with another email.", StatusCode.USER_ALREADY_EXIST);
		}
			User admin = modelMapper.map(userModel, User.class);
		
		
		admin.setPassword(passwordEncoder.encode(userModel.getPassword()));
		admin.setRoles(Arrays.asList(roleRepository.findByRoleName(ERole.ROLE_ADMIN)));
		try
		{
			userRepository.save(admin);
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}
		
			
		return  "Admin registered successfully !";
	}


	@Override
	public Map<String, Object> login(LoginModel loginModel)
	{
		Map<String, Object> data = new HashMap<>();
		
		Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		org.springframework.security.core.userdetails.User usrFromSecurity =(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		
		
		 List<String> roles = usrFromSecurity.getAuthorities().stream().map((item) -> item.getAuthority()).collect(Collectors.toList());
		 
			data.put("message", "Login Successful!!");
			data.put("role", roles);
			data.put("username", usrFromSecurity.getUsername());
			
			return data;
	}

}

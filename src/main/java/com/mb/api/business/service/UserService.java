package com.mb.api.business.service;

import java.util.Map;
import com.mb.api.business.exception.CustomException;
import com.mb.api.web.Model.LoginModel;
import com.mb.api.web.Model.UserModel;

public interface UserService
{
  String saveUser(UserModel userModel) throws CustomException;
  
  String saveAdmin(UserModel userModel) throws CustomException;
  
  Map<String, Object> login(LoginModel loginModel);
  
}

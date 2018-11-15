package com.sdust.service;

import com.sdust.entity.User;

public interface ILoginService {
	void login(String name,String pwd);		//��¼
	void register(User user);				//ע��
	boolean userIsExist(String name);
	boolean userIsLogin(String name);
	void lock(User user);
}

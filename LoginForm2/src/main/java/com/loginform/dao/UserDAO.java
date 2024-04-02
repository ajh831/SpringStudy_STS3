package com.loginform.dao;

import com.loginform.myapp.User;

public interface UserDAO {
	// 사용자 보기
	User selectUser(String id) throws Exception;
	
	// 사용자 정보를 저장
	 int insertUser(User user) throws Exception;

	
}

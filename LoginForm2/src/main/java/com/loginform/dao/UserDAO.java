package com.loginform.dao;

import com.loginform.myapp.User;

public interface UserDAO {
	// DBConnection Test
	String getServerTime() throws Exception;
	
	// 회원정보 확인 : 사용자 정보 보기
	User selectUser(String id) throws Exception;
	
	// 회원 가입 : 사용자 정보를 저장
	int insertUser(User user) throws Exception;

	// 아이디 확인 : 회원가입시 동일 아이디가 존해하는지 확인
	int selectUserId(String id) throws Exception;

	// 회원정보 수정 : 사용자 정보를 update
	User updateUser(User user) throws Exception;
	
	// 회원 탈퇴 : 사용자 정보를 삭제
	String deleteUser(User user) throws Exception;
}

package com.loginform.dao;

import java.util.List;

import com.loginform.myapp.Board;

public interface BoardDAO {
	
	// 게시글 개수 확인
	int count() throws Exception;
	
	// 게시글 화면에 뿌려주기
	List<Board> selectAll() throws Exception;
	
	// 게시글 추가하기
	int insert(Board board) throws Exception;
	
}

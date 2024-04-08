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
	
	// 게시글 선택하기
	Board select(Integer bno) throws Exception;
	
	// 게시글 업데이트
	int update(Board board) throws Exception;
	
	// 게시글 삭제하기
	int delete(Integer bno, String writer) throws Exception;
}

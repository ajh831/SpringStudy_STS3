package com.loginform.service;

import java.util.List;
import java.util.Map;

import com.loginform.myapp.Board;

public interface BoardService {
	
	// 게시글 수 가져오기
	int getCount() throws Exception;
	
	// 게시글 삭제하기
	int remove(Integer bno, String writer) throws Exception;
	
	// 게시글 작성하기
	int write(Board board) throws Exception;
	
	// 게시글 전체
//	List<Board> getList() throws Exception;
	
	// 게시글 읽기
	Board read(Integer bno) throws Exception;
	
	// 게시글 수정
	int modify(Board board) throws Exception;

	// pageSize만큼 게시글 보여주기
	List<Board> getPage(Map map) throws Exception;

//	int modify(Board board) throws Exception;
}

package com.loginform.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.loginform.myapp.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession session;

	private static String namespace = "com.loginform.dao.BoardMapper.";

	@Override
	public int count() throws Exception {
		System.out.println("count 확인");
		return session.selectOne(namespace + "count");
	}

	@Override
	public List<Board> selectAll() throws Exception {
		 return session.selectList(namespace+"selectAll");
	}

}

package com.loginform.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public int insert(Board board) throws Exception {
		return session.insert(namespace+"insert", board);
	}

	@Override
	public Board select(Integer bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }

	@Override
	public int update(Board board) throws Exception {
		return session.update(namespace + "update", board);
	}

	@Override
	public int delete(Integer bno, String writer) throws Exception {
		Map map = new HashMap();
		map.put("bno", bno);
		map.put("writer", writer);
		return session.delete(namespace + "delete", map);
	}

	@Override
	public List<Board> selectList(Map map) throws Exception {
		return session.selectList(namespace + "selectPage", map);
	}
}

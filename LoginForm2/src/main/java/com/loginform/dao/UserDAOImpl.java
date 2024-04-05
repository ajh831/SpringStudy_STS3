package com.loginform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.loginform.myapp.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlSession session;
	@Autowired
	DataSource ds;

	private static String namespace = "com.loginform.dao.UserMapper.";

	@Override
	public String getServerTime() throws Exception {
//		Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.
		
		return session.selectOne(namespace + "now");
	}

	@Override
	public User selectUser(String id) throws Exception{
		Connection conn = ds.getConnection();
		
		System.out.println("user select 했음");
		
		return session.selectOne(namespace + "selectUser", id);
	}

	@Override
	public int insertUser(User user) throws Exception {
		return session.insert(namespace + "insert", user);
	}

	@Override
	public User updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private void close(AutoCloseable... acs) {
		for (AutoCloseable ac : acs)
			try {
				if (ac != null)
					ac.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}

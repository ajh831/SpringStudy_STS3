package com.loginform.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.loginform.myapp.User;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SqlSession session;
    
    private static String namespace = "com.loginform.dao.UserMapper.";
    
    @Override
    public String getServerTime() throws Exception {
    	return session.selectOne(namespace + "now");
    }

	@Override
	public User selectUser(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
}

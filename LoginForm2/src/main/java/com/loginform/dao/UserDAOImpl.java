package com.loginform.dao;

import com.loginform.myapp.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;

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
	public int selectUserId(String id) throws Exception {
		Integer cnt = session.selectOne(namespace + "selectUserCount", id);
		System.out.println("cnt 확인중 여기는 유저다오 : " + cnt);

		cnt = cnt != null ? cnt : 0;
		System.out.println("cnt 확인중 여기는 유저다오 : " + cnt);

		return cnt;
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

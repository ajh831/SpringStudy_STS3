package com.loginform.myapp;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.loginform.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class UserDAOImplTest {
	@Autowired
	UserDAO userDAO;
	@Autowired
	DataSource ds;

	@Autowired
	private SqlSession session;

	private static String namespace = "com.loginform.dao.UserMapper.";

	@Test
	public void getServerTime() throws Exception {
		String now = userDAO.getServerTime();
		System.out.println("DBConnection now : " + now);
	}

	@Test
	public void getServerTimeMapper() throws Exception {
		Connection conn = ds.getConnection(); // 데이터베 이스의 연결을 얻는다.
		System.out.println("getServerTime : " + session.selectOne(namespace + "now"));
	}
	
	@Test
	public void selectUserTest() throws Exception {
		User test = userDAO.selectUser("asdf");
		System.out.println("selectUser Test : " + test.getId());
	}

	@Test
	public void selectIDTest() throws Exception {
		User user2 = selectUser("asdf");
		System.out.println("selectIDTest user2 : " + user2);

		assertTrue(user2.getId().equals("asdf"));
	}

	@Test
	public void insertUserTest() throws Exception {
		String dateString = "2024-04-03";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateString, formatter);
		java.sql.Date javaDate = java.sql.Date.valueOf(date);

		System.out.println("javaDate : " + javaDate);

		User user = new User("test", "1234", "고길동", javaDate, "경기도", new Date());
		userDAO.insertUser(user);
		System.out.println("insertUser : " + user);
	}

	@Test
	public void insertUserTest2() throws Exception {
		String dateString = "2024-04-03";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateString, formatter);
		java.sql.Date javaDate = java.sql.Date.valueOf(date);

		System.out.println("javaDate : " + javaDate);

		User user = new User("test2", "1234", "안정훈", javaDate);

		System.out.println("insertUserTest2 : " + user);

		userDAO.insertUser(user);
		System.out.println("insertUser : " + user);
	}

	public User selectUser(String id) throws Exception {
		Connection conn = ds.getConnection();

		String sql = "select * from registerTB where id= ? ";

		PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery(); // select

		if (rs.next()) {
			User user = new User();
			user.setId(rs.getString(1));
			user.setPwd(rs.getString(2));
			user.setName(rs.getString(3));
			user.setBirth(new Date(rs.getDate(4).getTime()));
			user.setAddress(rs.getString(5));
			user.setReg_date(new Date(rs.getTimestamp(6).getTime()));
			return user;
		}
		return null;
	}

}
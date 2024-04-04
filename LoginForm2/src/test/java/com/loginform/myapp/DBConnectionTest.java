package com.loginform.myapp;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.loginform.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class DBConnectionTest {
	@Autowired
	DataSource ds; // 컨테이너로부터 자동 주입받는다.

	@Test
	public void jdbcConnectionTest() throws Exception {

		Connection conn = ds.getConnection(); // 데이터베 이스의 연결을 얻는다.

		System.out.println("conn = " + conn);
		assertTrue(conn != null);
	}

//	@Test
//	public void deleteUserTest() throws Exception {
//		deleteAll();
//	}

	@Test
	public void selectTest() throws Exception {
		User user2 = selectAll();

		System.out.println("user2 : " + user2);

		assertTrue(user2.getId().equals("asdf"));
	}
	

	@Test
	public void selectUserTest() throws Exception {
		deleteAll();
		User user = new User("asdf", "1234", "홍길동", new Date(), "서울특별시", new Date());
		int rowCnt = insertUser(user);
		System.out.println("rowCnt : " + rowCnt);
		User user2 = selectUser("asdf");

		assertTrue(user.getId().equals("asdf"));
	}

	@Test
	public void selectIDTest() throws Exception {
		User user2 = selectUser("asdf");
		System.out.println("selectIDTest user2 : " + user2);
		
		assertTrue(user2.getId().equals("asdf"));
	}

	//	"asdf", "1234", "홍길동", new Date(), "서울특별시", new Date()

	private void deleteAll() throws Exception {
		Connection conn = ds.getConnection();

		String sql = "delete from registerTB ";

		PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
		pstmt.executeUpdate(); // insert, delete, update
	}

	public User selectAll() throws Exception {
		Connection conn = ds.getConnection();

		String sql = "select * from registerTB";

		PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
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

	public int insertUser(User user) throws Exception {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;

//		String sql = "insert into registerTB values (?, ?, ?)";
		String sql = "insert into registerTB(id,pwd,name,birth,address,reg_date) values (?, ?, ?, ?, ?, ?)";
		System.out.println("확인중:" +user.getBirth().getTime());
		pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPwd());
		pstmt.setString(3, user.getName());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(new java.sql.Date(user.getBirth().getTime()));
		pstmt.setDate(4, java.sql.Date.valueOf(formattedDate));
//		pstmt.setString(4, "2014-01-01");
		
		pstmt.setString(5, user.getAddress());
		
		formattedDate = sdf.format(new java.sql.Date(user.getReg_date().getTime()));
		pstmt.setDate(6, java.sql.Date.valueOf(formattedDate));
//		pstmt.setString(6,"2014-01-01");

		int rowCnt = pstmt.executeUpdate(); // insert, delete, update;
        return rowCnt;
	}
}

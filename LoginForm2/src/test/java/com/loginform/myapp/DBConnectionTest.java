package com.loginform.myapp;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.loginform.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnectionTest {
    @Autowired
    DataSource ds; // 컨테이너로부터 자동 주입받는다.
    @Autowired
    UserDAO userDao;

	@Test
	public void jdbcConnectionTest() throws Exception {
//		ApplicationContext ac = new GenericXmlApplicationContext(
//				"file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
//		DataSource ds = ac.getBean(DataSource.class);

		Connection conn = ds.getConnection(); // 데이터베                                                                                                                                                                                                                                                                                                     이스의 연결을 얻는다.

		System.out.println("conn = " + conn);
		assertTrue(conn != null);
	}
	
//	@Test
//	public User selectTest() throws Exception {
////		ApplicationContext ac = new GenericXmlApplicationContext(
////				"file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
////		DataSource ds = ac.getBean(DataSource.class);
//		
//		Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.
//
//        String sql = "select * from registerTB where id= ? ";
//
//        PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
//        pstmt.setString(1,"asdf");
//        ResultSet rs = pstmt.executeQuery(); //  select
//
//        if(rs.next()) {
//            User user = new User();
//            pstmt.setString(1, user.getId());
//            pstmt.setString(2, user.getPwd());
//            pstmt.setString(3, user.getName());
//            pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
//            pstmt.setString(5, user.getAddress());
//            return user;
//        }
//        return null;
//	}
}

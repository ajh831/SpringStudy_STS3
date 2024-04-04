package com.loginform.myapp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.loginform.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDAOImplTest {
    @Autowired
    UserDAO userDAO;
    
    @Autowired
    private SqlSession session;
    
    private static String namespace = "com.loginform.dao.UserMapper.";

    @Test
    public void getServerTime() throws Exception {
    	String now = userDAO.getServerTime();
    	System.out.println("DBConnection now : " + now);
    	
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
    
}
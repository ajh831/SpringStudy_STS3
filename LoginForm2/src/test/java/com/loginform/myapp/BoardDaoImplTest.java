package com.loginform.myapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.loginform.dao.BoardDAO;
import com.loginform.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDaoImplTest {
    @Autowired
    BoardDAO boardDao;
    @Autowired
    UserDAO userDao;
    @Autowired
    ApplicationContext ac;

	private static String namespace = "com.loginform.dao.BoardMapper.";
	
	@Test
	public void countTest() throws Exception {
//		System.out.println("ac : " + ac);
//		System.out.println("user : " + userDao);
//		System.out.println("ac ; " + ac.getBeanDefinitionNames());
//		System.out.println("나 왔어~");
//		System.out.println(boardDao);
		System.out.println(boardDao.count()); // NullPointerException
		int cnt = boardDao.count();
//		
		assertTrue(cnt == 160);
	}
	
	@Test
	public void selectAllTest() throws Exception {
		System.out.println("boardDao : " + (boardDao.selectAll() instanceof BoardDAO));
		System.out.println("selectAll : " + boardDao.selectAll());
	}

}
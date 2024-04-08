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
import com.loginform.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDaoImplTest {
    @Autowired
    BoardDAO boardDao;
    @Autowired
    UserDAO userDao;
    @Autowired
    ApplicationContext ac;
    @Autowired
    BoardService boardService;

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
//		assertTrue(cnt == 116);
	}
	
	@Test
	public void selectAllTest() throws Exception {
		System.out.println("boardDao : " + (boardDao.selectAll() instanceof BoardDAO));
		System.out.println("selectAll : " + boardDao.selectAll());
	}
	
	@Test
	public void insertTest() throws Exception {
//		Board board = null;
//		board.setTitle("test");
//		board.setContent("테스트 중");
//		board.setWriter("test");
//		System.out.println("selectAll : " + boardService.write(board));
		
		Board board = new Board("insertTest", "no content", "asdf");
        assertTrue(boardDao.insert(board)==1);
	}
	
	@Test
	public void readTest() throws Exception {
		Board board = boardService.read(111);
		System.out.println("getBno test : " + board.getBno());
		assertTrue(board.getBno() == 111);
	}
	
	@Test
	public void modifyTest() throws Exception {
		Board board = boardService.read(134);
		board.setTitle("수정테스트2");
		board.setContent("수정 테스트2 : 내용");
		assertTrue(boardService.modify(board) == 1);
	}
	
	@Test
	public void removeTest() throws Exception {
//		boardService.remove(138, "asdf");
		assertTrue(boardService.remove(138, "asdf") == 1);
	}
}

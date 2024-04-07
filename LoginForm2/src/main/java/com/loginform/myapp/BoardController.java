package com.loginform.myapp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loginform.dao.BoardDAO;
import com.loginform.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	BoardDAO boardDao;
    @Autowired
    BoardService boardService;

	@RequestMapping(value = "/list")
	public String boardList(Model model) throws Exception {
		List<Board> boardlist = boardDao.selectAll();
		model.addAttribute("boardList", boardlist);

		Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
		model.addAttribute("startOfToday", startOfToday.toEpochMilli());
		return "/login/board";
	}

	@GetMapping(value = "/write")
	public String boardWrite(Model model) throws Exception {

		return "/login/boardWrite";
	}

	@PostMapping(value = "/insert")
	public String boardWrite(HttpServletRequest request, Board board, Model model, HttpSession session) throws Exception {
		String writer = (String) session.getAttribute("id");
		board.setWriter(writer);

		System.out.println("board writer : " + board.getWriter());
		System.out.println("board title : " + board.getTitle());
		System.out.println("board content : " + board.getContent());

		boardService.write(board);
		
		
		return "redirect:/board/list";
	}

}
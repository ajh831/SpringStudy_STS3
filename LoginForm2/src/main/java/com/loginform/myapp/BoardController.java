package com.loginform.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loginform.dao.BoardDAO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	BoardDAO boardDao;

	@RequestMapping(value = "/list")
	public String BoardList(Model model) throws Exception {
		List<Board> boardlist = boardDao.selectAll();
		model.addAttribute("boardList", boardlist);
		return "/login/board";
	}

}
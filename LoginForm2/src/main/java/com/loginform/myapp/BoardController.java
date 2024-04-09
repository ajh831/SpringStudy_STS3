package com.loginform.myapp;

import com.loginform.dao.BoardDAO;
import com.loginform.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	BoardDAO boardDao;
    @Autowired
    BoardService boardService;

	@RequestMapping(value = "/list")
	public String boardList(@RequestParam(defaultValue ="1") Integer page,
            				@RequestParam(defaultValue = "10") Integer pageSize, Model model) throws Exception {

		// 페이지 전체 개수대로 보여주기
//		List<Board> boardlist = boardDao.selectAll();
//		model.addAttribute("boardList", boardlist);

		Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
		model.addAttribute("startOfToday", startOfToday.toEpochMilli());

		// 페이징 처리를 하기위해서 전체페이지 개수를 구함
		int totalCnt = boardService.getCount();
		// PageHandler(전체페이지수, 현재페이지(default 1), pageSize(default 10))
		PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

		System.out.println("begin Page : " + pageHandler.getBeginPage());
		System.out.println("end Page : " + pageHandler.getEndPage());
		model.addAttribute("ph", pageHandler);

		Map map = new HashMap();
		map.put("offset", (pageHandler.getPage()-1) * pageHandler.getPageSize());
		map.put("pageSize", pageHandler.getPageSize());

		List<Board> boardlist = boardDao.selectList(map);
		
		return "/login/board";
	}

	@RequestMapping(value = "/new")
	public String newBoard(Model model) throws Exception {
		List<Board> boardlist = boardDao.selectAll();
		int bno = boardlist.get(0).getBno();
		
		return  "redirect:/board/read?bno=" + bno;
	}

	@GetMapping(value = "/write")
	public String boardWrite(Model model) throws Exception {
		model.addAttribute("mode", "new");
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
	
	@RequestMapping("/read")
	public String read(Integer bno, Model model, HttpSession session) throws Exception {
		Board board = boardService.read(bno);
		System.out.println("read에서 bno 확인중 : " + board.getBno());
		model.addAttribute("Board", board);
		model.addAttribute("loginId", session.getAttribute("id"));
		
//		return "redirect:/board/write";
		return "/login/boardWrite";
	}
	
	@RequestMapping("/update")
	public String update(Board board, Model model, HttpSession session) throws Exception {
		String writer = (String) session.getAttribute("id");
		board.setWriter(writer);
		
		boardService.modify(board);
		System.out.println("update 확인중(bno) 확인 : " + board.getBno());
		System.out.println("update 확인중 : " + board.getTitle());
		model.addAttribute("Board", board);
		
		return "redirect:/board/read?bno=" + board.getBno();
	}
	
	@RequestMapping("/remove")
	public String remove(Integer bno, Model model, HttpSession session) throws Exception {
		String writer = (String) session.getAttribute("id");
		boardService.remove(bno, writer);
		
		return "redirect:/board/list";
	}

}
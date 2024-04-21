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
	public String boardList(@RequestParam(defaultValue ="1") int page,
            				@RequestParam(defaultValue = "10") int pageSize, Model model, HttpServletRequest request) throws Exception {

		// 페이지 전체 개수대로 보여주기
//		List<Board> boardlist = boardDao.selectAll();
//		model.addAttribute("boardList", boardlist);

		Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
		model.addAttribute("startOfToday", startOfToday.toEpochMilli());

		// 페이징 처리를 하기위해서 전체페이지 개수를 구함
		int totalCnt = boardService.getCount();
		// PageHandler(전체페이지수, 현재페이지(default 1), pageSize(default 10))
		System.out.println("page input 확인: " + page);
		PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

		System.out.println("start Page : " + pageHandler.getStartPage());
		System.out.println("end Page : " + pageHandler.getEndPage());
		model.addAttribute("ph", pageHandler);

		System.out.println("프린트문 확인2");

		Map map = new HashMap();
		map.put("offset", (page-1)*10);
//		map.put("startPage", pageHandler.getStartPage()-1);
//		map.put("endPage", pageHandler.getEndPage());
		map.put("pageSize", pageSize);

//		map.put("startPage", 1);
//		map.put("endPage", 10);
		System.out.println("프린트문 확인1");

		System.out.println("startPage check: " + map.get("startPage"));
		System.out.println("endPage check: " + map.get("endPage"));
//		map.put("getEndPage", pageHandler.getEndPage());

		List<Board> boardlist = boardService.getPage(map);
		System.out.println("boardList print : " + boardlist);
//		Iterator it = boardlist.iterator();
//		// while문을 사용한 경우
//		while(it.hasNext())
//		{
//			System.out.println("iterator test");
//			String str = it.next().toString();
//			System.out.println(str);
//		}

		model.addAttribute("boardList", boardlist);
		model.addAttribute("ph", pageHandler);

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
		System.out.println("read에서 view_cnt 확인중 : " + board.getView_cnt());
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
package com.loginform.service;

import com.loginform.dao.BoardDAO;
import com.loginform.myapp.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDAO boardDao;
	
	@Override
	public int getCount() throws Exception {
        return boardDao.count();
	}

	@Override
	public int remove(Integer bno, String writer) throws Exception {
		return boardDao.delete(bno, writer);
	}

    @Override
    public int write(Board board) throws Exception {
        return boardDao.insert(board);
    }

	@Override
	public Board read(Integer bno) throws Exception {
		boardDao.increaseViewCnt(bno);

		return boardDao.select(bno);
	}

	@Override
	public int modify(Board board) throws Exception {
		return boardDao.update(board);
	}

	@Override
	public List<Board> getPage(Map map) throws Exception {
		System.out.println("Service map startPage : " + map.get("startPage"));
		System.out.println("Service map endPage : " + map.get("endPage"));
		return boardDao.selectList(map);
	}

}
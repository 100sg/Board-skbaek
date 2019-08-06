package com.skbaek.board.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skbaek.board.entity.Board;
import com.skbaek.board.repository.BoardListRepository;
import com.skbaek.board.service.BoardService;

@Service
public class MainBoardService implements BoardService{
	
	Logger logger = LoggerFactory.getLogger(MainBoardService.class); 

	@Autowired
	private BoardListRepository boardRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<Board> list(final Pageable page) throws Exception {
		Page<Board> dataList = boardRepository.findAll(page);
		return dataList; 
	}

	@Override
	@Transactional
	public Board save(Board param) throws Exception {
//		Date registDate = Util.getNowToDate("yyyy-MM-dd HH:mm:ss", "seoul");
//		param.setEnrollTime(registDate);
		return boardRepository.save(param);
	}

	@Override
	@Transactional
	public Board update(Board board) throws Exception {
//		Date updateDate = Util.getNowToDate("yyyy-MM-dd HH:mm:ss", "seoul");
//		board.setUpdateTime(updateDate);
		return boardRepository.save(board);
	}

	@Override
	public void del(Board board) {
		boardRepository.delete(board);
	}

	@Override
	public Optional<Board> detail(Board board) {
		return boardRepository.findById(board.getNo());
	}


}

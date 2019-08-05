package com.skbaek.board.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skbaek.board.controller.BoardController;
import com.skbaek.board.entity.Board;
import com.skbaek.board.repository.BoardListRepository;
import com.skbaek.board.service.BoardService;
import com.skbaek.board.util.Util;

@Service
public class MainBoardService implements BoardService{
	
	Logger logger = LoggerFactory.getLogger(MainBoardService.class); 

	@Autowired
	private BoardListRepository boardRepository;

	@Override
	@Transactional
	public List<Board> list() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> responseMap = new HashMap<>();

		List<Board> dataList = boardRepository.findAll();
		
		responseMap.put("data", dataList);
		
		logger.debug("data : {}", dataList);
		
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

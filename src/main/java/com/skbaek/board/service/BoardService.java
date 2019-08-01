package com.skbaek.board.service;

import java.util.List;
import java.util.Map;

import com.skbaek.board.entity.Board;

public interface BoardService {
	
	List<Board> list() throws Exception;
	void save(Board board) throws Exception;
	void update(Board board) throws Exception;
	
}

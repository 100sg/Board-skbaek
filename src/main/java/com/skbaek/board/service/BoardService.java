package com.skbaek.board.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.skbaek.board.entity.Board;

public interface BoardService {
	
	List<Board> list() throws Exception;
	Board save(Board board) throws Exception;
	Board update(Board board) throws Exception;
	void del(Board board);
	Optional<Board> detail(Board board);
	
}

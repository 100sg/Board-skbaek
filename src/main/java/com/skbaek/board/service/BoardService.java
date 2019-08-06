package com.skbaek.board.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skbaek.board.entity.Board;

public interface BoardService {
	
	Page<Board> list(Pageable page) throws Exception;
	Board save(Board board) throws Exception;
	Board update(Board board) throws Exception;
	void del(Board board);
	Optional<Board> detail(Board board);
	
}

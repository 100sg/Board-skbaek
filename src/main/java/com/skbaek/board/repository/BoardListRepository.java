package com.skbaek.board.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skbaek.board.entity.Board;

public interface BoardListRepository extends JpaRepository<Board, Long>{
	
	Page<Board> findAll(Pageable request);

}

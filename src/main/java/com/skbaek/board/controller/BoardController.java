package com.skbaek.board.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skbaek.board.entity.Board;
import com.skbaek.board.entity.PageRequest;
import com.skbaek.board.service.BoardService;


@RestController
@RequestMapping("/sk")
public class BoardController {

	Logger logger = LoggerFactory.getLogger(BoardController.class); 

	private BoardService mService;
	
	public BoardController(BoardService service) {
		this.mService = service;
	}

	@GetMapping("/list")
	public ResponseEntity<?> list(final PageRequest page) throws Exception {
		logger.debug("TRACE1 : {}", page.toString());
		return ResponseEntity.ok(this.mService.list(page.of()));
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insert(@RequestBody Board param) throws Exception{
		logger.debug("TRACE insert : {}", param.toString() );
		
		Board board = mService.save(param);
		URI uri = ControllerLinkBuilder.linkTo(BoardController.class).slash(board.getNo()).toUri();
		return ResponseEntity.created(uri).body(board);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Board param) throws Exception{
		Board board = mService.update(param);
		URI uri = ControllerLinkBuilder.linkTo(BoardController.class).slash(board.getNo()).toUri();
		logger.debug("TRACE update uri : {} \n board : {}", uri, board);
		
		return ResponseEntity.created(uri).body(board);
	}
	
	@PostMapping("/del")
	public ResponseEntity<?> del(@RequestBody Board param) {
		mService.del(param);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/detail")
	public ResponseEntity<?> inquire(@RequestBody Board param){
		
		return ResponseEntity.ok(mService.detail(param));
	}
	
}

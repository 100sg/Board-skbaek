package com.skbaek.board.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skbaek.board.entity.Board;
import com.skbaek.board.service.BoardService;


@RestController
@RequestMapping("/sk")
public class BoardController {

	Logger logger = LoggerFactory.getLogger(BoardController.class); 

	@Autowired
	BoardService mService;
	
	@GetMapping("/list")
	public List<Board> list() {
		List<Board> list = null;
		try {
			list = mService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insert(@RequestBody Board param){
		logger.debug("TRACE insert : {}", param.toString() );
		
		try {
			mService.save(param);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(){
		
		try {
			double a = 1/0;
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("FAIL",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	
}

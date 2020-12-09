package com.sudoku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudoku.model.Board;
import com.sudoku.service.SudokuService;

@RestController
@RequestMapping("/sudoku")
@CrossOrigin
public class SudokuController {
	@Autowired
	private SudokuService ss;
	
	@PostMapping
	public boolean validation(@RequestBody Board requestBoard) {
		requestBoard.getBoard().forEach(System.out::println);
		
		return ss.validate(requestBoard);
	}
}

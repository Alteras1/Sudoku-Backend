package com.sudoku.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sudoku.model.Board;

@SpringBootTest
class SudokuServiceTest {

	@Autowired
	SudokuService ss;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void validArrayTest() {
		ArrayList<Integer> valid = new ArrayList<Integer>( Arrays.asList(1,2,3,4,5,6,7,8,9));
		assertTrue(ss.validArray(valid));
		ArrayList<Integer> invalid = new ArrayList<Integer>(Arrays.asList(1,2,3,7,8,9));
		assertFalse(ss.validArray(invalid));
		invalid = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,6,8,9));
		assertFalse(ss.validArray(invalid));
	}

}

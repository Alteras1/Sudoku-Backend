package com.sudoku.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.sudoku.model.Board;

@Service
public class SudokuService {

	private static final Set<Integer> CHECKER = new TreeSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

	/**
	 * Checks if board is a valid Sudoku board
	 * 
	 * @param board
	 * @return Boolean
	 */
	public boolean validate(Board board) {
		if (!(validSize(board)))
			return false;
		// By Row
		for (ArrayList<Integer> row : board.getBoard())
			if (!(validArray(row)))
				return false;

		// By Col
		for (int x = 0; x < 9; x++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int y = 0; y < 9; y++)
				temp.add(board.getBoard().get(y).get(x));
			if (!(validArray(temp)))
				return false;
		}

		// By Grid
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int x = 0; x < 3; x++)
					for (int y = 0; y < 3; y++)
						temp.add(board.getBoard().get(x + 3 * i).get(y + 3 * j));
				if (!(validArray(temp)))
					return false;
			}

		return true;
	}

	/**
	 * Checks if board is a valid 9x9 board
	 * 
	 * @param board
	 * @return Boolean
	 */

	boolean validSize(Board board) {
		if (board.getBoard().size() != 9)
			return false;
		for (ArrayList<Integer> row : board.getBoard())
			if (row.size() != 9)
				return false;
		return true;
	}

	/**
	 * Checks an array is a valid array of non-repeating 1-9 elements or empty
	 * 
	 * @param arrayList<Integer>
	 * @return Boolean
	 */
	boolean validArray(ArrayList<Integer> arrayList) {
		Set<Integer> temp = new TreeSet<Integer>();
		for (int i : arrayList)
			if (!(temp.add(i) && CHECKER.contains(i)))
				return false;
		return true;
	}
}

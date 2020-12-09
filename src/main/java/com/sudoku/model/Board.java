package com.sudoku.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

	private ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
}

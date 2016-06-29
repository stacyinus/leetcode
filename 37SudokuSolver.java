/*
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/
/*
	思路： number should be unique in its column, row and subgrid.
		  loop through the list
		  
*/

public class Solution {
    public void solveSudoku(char[][] board) {
    	canSovle(board);
    }

    private boolean canSovle(char[][] board) {
    	for (int i = 0; i < 9; i ++) {
    		for (int j = 0; j < 9; j++) {
    			if(board[i][j] == '.') {
    				for (char c = '1'; c <= '9'; c ++) {
    					board[i][j] = c;
    					if(isValid(board,i,j) && canSovle(board)) {
    						return true;
    					}
    					board[i][j] = '.';
    				}
    				return false;
    			}
    		}
    	}
    	return true; // doesn't matter what to return here.
    }
    private boolean isValid(char[][] board, int i, int j) {
    	Set<Character> set = new HashSet<Character>();
    	//row valid
    	for(int c = 0; c < 9; c++ ) {
    		if(board[i][c] != '.' && set.contains(board[i][c])) return false;
    		set.add(board[i][c]);
    	}
    	//col valid
    	set = new HashSet<Character>();
    	for(int r = 0; r < 9; r++ ) {
    		if(board[r][j] != '.' && set.contains(board[r][j])) return false;
    		set.add(board[r][j]);
    	}
    	//grid valid
    	int rs = i/3 * 3;
    	int cs = j/3 * 3;
    	set = new HashSet<Character>();
    	for(int r = rs; r - rs < 3; r ++) {
    		for(int c = cs; c - cs < 3; c++) {
    			if(board[r][c] != '.' && set.contains(board[r][c])) return false;
    			set.add(board[r][c]);
    		}
    	}
    	return true;
    }

}
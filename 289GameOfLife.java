/*
289. Game of Life

According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time:
You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, 
which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/
public class Solution {
	//Not in place
    public void gameOfLife(int[][] board) {
    	if(board==null||board.length==0||board[0].length==0) return;
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        	for(int j=0;j<board[0].length;j++)
        		setNewVal(board, newBoard, i, j);
        for(int i=0;i<board.length;i++)
        	for(int j=0;j<board[0].length;j++)
        		board[i][j]=newBoard[i][j];
    }
    private void setNewVal(int[][] board, int[][] newBoard, int i, int j){
    	int rowS = i>0?i-1:i;
    	int colS = j>0?j-1:j;
    	int rowE = i<board.length-1?i+1:i;
    	int colE = j<board[0].length-1?j+1:j;
    	int live = 0;
    	for(int r = rowS;r<=rowE;r++){
    		for(int c = colS;r<=colE;c++){
    			if(r==i&&c==j)
    				continue;
    			if(board[r][c]==1)
    				live++;
    		}
    	}
    	if(board[i][j]==1){
    		if(live<2||live>3)
    			newBoard[i][j]=0;
    		else 
    			newBoard[i][j]=1;
    	}
    	else if(board[i][j]==0&&live==3)
    		newBoard[i][j]=1;
    	else
    		newBoard[i][j]=board[i][j];
    }
    //In place
    //https://leetcode.com/discuss/68352/easiest-java-solution-with-explanation
    public void gameOfLife(int[][] board) {
    	if(board==null||board.length==0||board[0].length==0) return;
    	int live = 0;
    	for(int i=0;i<board.length;i++)
        	for(int j=0;j<board[0].length;j++){
        		live= getLive(board, i, j);
        		if(board[i][j]==1&&(live==2||live==3))
        			board[i][j]=3;
        		else if(board[i][j]==0&&live==3)
        			board[i][j]=2;
        	}
    }

}
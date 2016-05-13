/*
130. Surrounded Regions 

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X	
*/

public class Solution {
	class Pair{
		int row;
		int col;
		Pair(int r, int c){
			row = r;
			col = c;
		}
	}
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
        	return;
        Queue<Pair> q = new LinkedList<Pair>();
		for(int i = 0; i < board[0].length; i++){
			if(board[0][i] == 'O')
					q.offer(new Pair(0, i));
			if(board[board.length - 1][i] == 'O')
					q.offer(new Pair(board.length - 1, i));
		}

		for(int i = 0; i < board.length; i++){
			if(board[i][0] == 'O')
					q.offer(new Pair(i, 0));
			if(board[i][board[i].length - 1] == 'O')
					q.offer(new Pair(i, board[i].length - 1));	
		}
        
        while(!q.isEmpty()){
			Pair tmp = q.poll();
			board[tmp.row][tmp.col] = 'B';
			if(tmp.row + 1 < board.length && board[tmp.row + 1][tmp.col] == 'O')
				q.offer(new Pair(tmp.row + 1, tmp.col));
			if(tmp.col + 1 < board[tmp.row].length && board[tmp.row][tmp.col + 1] == 'O')
				q.offer(new Pair(tmp.row, tmp.col + 1));
			if(tmp.row - 1 >= 0 && board[tmp.row - 1][tmp.col] == 'O')
				q.offer(new Pair(tmp.row - 1, tmp.col));
			if(tmp.col - 1 >= 0 && board[tmp.row][tmp.col - 1] == 'O')
				q.offer(new Pair(tmp.row, tmp.col - 1));
		}        
        
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[i].length; j++){
        		if(board[i][j] == 'B')
        			board[i][j] = 'O';
        		else if( board[i][j] == 'O')
        			board[i][j] = 'X';
        	}
        }
    }
}



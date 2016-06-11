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
	//this is bfs solution which is kinda slow: O(n2)
	class Pair{
		int row;
		int col;
		Pair(int r, int c){
			row = r;
			col = c;
		}
	}
    //BFS
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
	// Version 2: Union Find
    class UnionFind{
    	int[] fathers;
    	public UnionFind(char[][] board){
    		fathers = new int[board.length * board[0].length];
    		for(int i = 0; i < board.length; i++)
    			for(int j = 0; j < board[0].length; j++)
    				if(board[i][j] == 'O')
    					fathers[i*board[0].length+j] = i*board[0].length+j;
    	}
    	public void union(int i, int j){
    		int f1 = find(i);
    		int f2 = find(j);
    		if(f1 != f2)
    			fathers[f2] = f1;
    	}
    	public int find(int i){
    		while(fathers[i] != i){
    			fathers[i] = fathers[fathers[i]];
    			i = fathers[i];
    		}
    		return i;
    	}
    }

    public void solve(char[][] board) {
    	if(board == null || board.length == 0 || board[0].length == 0)
    		return;
    	UnionFind uf = new UnionFind(board);
    	HashSet<Integer> boundries = new HashSet<Integer>();
    	HashSet<Integer> boundryFathers = new HashSet<Integer>();
    	for(int i = 0; i < board.length; i++)
    		for(int j = 0; j < board[0].length; j++)    	
    			if(board[i][j] == 'O'){
    				if(i > 0 && board[i-1][j] == 'O')
    					uf.union(i*board[0].length + j, (i-1)*board[0].length + j);
    				if(i < board.length - 1 && board[i+1][j] == 'O')
    					uf.union(i*board[0].length + j, (i+1)*board[0].length + j);
    				if(j > 0 && board[i][j-1] == 'O')
    					uf.union(i*board[0].length + j, i*board[0].length + j - 1);
    				if(j < board[0].length - 1 && board[i][j+1] == 'O')
    					uf.union(i*board[0].length + j, i*board[0].length + j + 1);	
    				if( i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
    					boundries.add(i*board[0].length + j);
    			}
    		for(int i : boundries)
    		    boundryFathers.add(uf.find(i));
                	//System.out.println( " i = " + i + " j = " + j);
                // 	for(int k = 0; k < uf.fathers.length; k++){
                // 	    System.out.print(uf.fathers[k] + "   ");
                // 	    if((k+1)%8 == 0)
                //     	    System.out.println();
                // 	}
                	
                // 	for(int b : boundryFathers)
                // 	    System.out.print(b + "   ");
                // 	System.out.println();  
    	for(int i = 0; i < board.length; i++)
    		for(int j = 0; j < board[0].length; j++) 
    			if(board[i][j] == 'O' && !boundryFathers.contains(uf.find(i*board[0].length + j)))
    				board[i][j] = 'X';
    }
}



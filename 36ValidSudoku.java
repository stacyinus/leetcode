/*

36. Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/

public class 36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet[] rows = new HashSet[9];
        HashSet[] cols = new HashSet[9];
        HashSet[][] cubs = new HashSet[3][3];
        for(int i=0;i<9;i++){
        	for(int j=0;j<9;j++){
        		if(board[i][j]=='.')
        			continue;
        		if(rows[i]==null)
        			rows[i] = new HashSet<Character>();
        		if(cols[j]==null)
        			cols[j] = new HashSet<Character>();
        		if(cubs[i/3][j/3]==null)
        			cubs[i/3][j/3] = new HashSet<Character>();
        		if(!(rows[i].add(board[i][j])&&cols[j].add(board[i][j])&&cubs[i/3][j/3].add(board[i][j])))
        			return false;
        	}
        }
        return true;
    }
}
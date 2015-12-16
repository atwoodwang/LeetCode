//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

//Note:
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
	        if(!checkValid(board,i,0,i,8)){
		        return false;
	        }
	        if(!checkValid(board,0,i,8,i)){
		        return false;
	        }
        }

        for(int i=0;i<9;i+=3){
	        for(int j=0;j<9;j+=3){
		        if(!checkValid(board,i,j,i+2,j+2)){
			        return false;
			    }
	        }
        }
        return true;
    }

    public boolean checkValid(char[][] board,int startx,int starty,int endx,int endy){
	    Set<Character> set = new HashSet<>();
		for(int i=startx;i<=endx;i++){
			for(int j=starty;j<=endy;j++){
				if(board[i][j]!='.'){
					if(!set.add(board[i][j])){
						return false;
					}
				}
			}
		}
		return true;
    }
}
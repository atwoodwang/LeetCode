//According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

//Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

//Any live cell with fewer than two live neighbors dies, as if caused by under-population.
//Any live cell with two or three live neighbors lives on to the next generation.
//Any live cell with more than three live neighbors dies, as if by over-population..
//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//Write a function to compute the next state (after one update) of the board given its current state.

//Follow up: 
//Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
//In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?


public class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
         
        for(int i=0;i<row;i++){
	        for(int j=0;j<col;j++){
		        int n = countLives(board,i,j,row,col);
		        if(board[i][j]==1&&(n==2||n==3)){
			        board[i][j]=3;
		        }
		        if(board[i][j]==0&&n==3){
			        board[i][j]=2;
		        }
	        }
        }

        for(int i=0;i<row;i++){
	        for(int j=0;j<col;j++){
		        board[i][j]>>=1;
	        }
        }
    }

    public int countLives(int[][] board,int x,int y,int row,int col){
	    int count = 0;
	    for(int i=Math.max(x-1,0);i<=Math.min(x+1,row-1);i++){
		    for(int j=Math.max(y-1,0);j<=Math.min(y+1,col-1);j++){
			    count+=board[i][j]&1;
		    }
	    }
	    count-=board[x][y]&1;
	    return count;
    }
}
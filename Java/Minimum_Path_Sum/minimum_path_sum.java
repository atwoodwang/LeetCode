//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

//Note: You can only move either down or right at any point in time.


public class Solution {
    public int minPathSum(int[][] grid) {
	    int row = grid.length;
        int column = grid[0].length;
        for(int i=1;i<row;i++){
	       	grid[i][0]+=grid[i-1][0];
        }
        for(int i=1;i<column;i++){
	        grid[0][j]+=grid[0][j-1];
        }
        for(int j=1;i<row;i++){
	        for(int k=1;k<column;k++){
		        grid[j][k]+=Math.min(grid[j-1][k],grid[j][k-1]);
	        }
        }
        return grid[row-1][column-1];
    }
}
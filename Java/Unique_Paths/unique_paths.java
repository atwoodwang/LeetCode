//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

//How many possible unique paths are there?

//Math Solution
public class Solution {
    public int uniquePaths(int m, int n) {
        int a = n + m - 2;
        int b = m - 1; 
        double res = 1;
        for (int i = 1; i <= b; i++)
            res = res * (a - b + i) / i;
        return (int)res;
    }
}

//Dynamic Programming Solution
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i=0;i<n;i++){
	        grid[0][i]=1;
        }
        for(int i=0;i<m;i++){
	        grid[i][0]=1;
        }
        for(int j=1;j<m;j++){
	        for(int k=1;k<n;k++){
		        grid[j][k]=grid[j-1][k]+grid[j][k-1];
	        }
        }
        return grid[m-1][n-1];
    }
}
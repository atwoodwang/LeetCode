//Follow up for "Unique Paths":

//Now consider if some obstacles are added to the grids. How many unique paths would there be?

//An obstacle and empty space is marked as 1 and 0 respectively in the grid.

//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.

//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.

//Note: m and n will be at most 100.


public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] result = new int[width];
		result[0]=1;
		for(int[] row:obstacleGrid){
			for(int i=0;i<width;i++){
				if(row[i]==1){
					result[i]=0;
				}else if(i>0){
					result[i]+=result[i-1];
				}
			}
		}
		return result[width-1];
    }
}
//You are given an n x n 2D matrix representing an image.

//Rotate the image by 90 degrees (clockwise).

//Follow up:
//Could you do this in-place?


public class Solution {
    public void rotate(int[][] matrix) {
	    int n = matrix.length;
        for(int i=0;i<n/2;i++){
	        for(int j=0;j<n;j++){
		        int temp = matrix[i][j];
		        matrix[i][j]=matrix[n-1-i][j];
		        matrix[n-1-i][j]=temp;
	        }
        }
        for(int i=0;i<n;i++){
	        for(int j=i+1;j<n;j++){
		        int temp = matrix[i][j];
		        matrix[i][j] = matrix[j][i];
		        matrix[j][i] = temp;
	        }
        }
    }
}
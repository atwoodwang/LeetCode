//A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

//For example, given three people living at (0,0), (0,4), and (2,2):

//1 - 0 - 0 - 0 - 1
//|   |   |   |   |
//0 - 0 - 0 - 0 - 0
//|   |   |   |   |
//0 - 0 - 1 - 0 - 0
//The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.


public class Solution {
    public int minTotalDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int i=0;i<row;i++){
	        for(int j=0;j<col;j++){
		        if(grid[i][j]==1) a.add(i);
	        }
        }

        for(int i=0;i<col;i++){
	        for(int j=0;j<row;j++){
		        if(grid[j][i]==1) b.add(i);
	        }
        }
        return calDistance(a)+calDistance(b);
    }

    public int calDistance(List<Integer> list){
	    int sum=0,start=0,end=list.size()-1;
	    while(start<end){
		    sum+=list.get(end--)-list.get(start++);
	    }
	    return sum;
    }
}
//There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

//The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

//Note:
//All costs are positive integers.

//Follow up:
//Could you solve it in O(nk) runtime?


public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length==0||costs==null) return 0;
        int n = costs.length,k = costs[0].length;
        int minIndex = -1,secMinIndex = -1;
        for(int i=0;i<n;i++){
            int min = minIndex, secMin = secMinIndex;
            minIndex = -1;secMinIndex = -1;
            for(int j=0;j<k;j++){
                if(j!=min){
                    costs[i][j]+=min<0?0:costs[i-1][min];
                }else{
                    costs[i][j]+=secMin<0?0:costs[i-1][secMin];
                }

                if(minIndex<0||costs[i][j]<costs[i][minIndex]){
                    secMinIndex = minIndex;
                    minIndex = j;

                }else if(secMinIndex<0||costs[i][j]<costs[i][secMinIndex]){
                    secMinIndex = j;
                }
            }
        }
        return costs[n-1][minIndex];
    }
}
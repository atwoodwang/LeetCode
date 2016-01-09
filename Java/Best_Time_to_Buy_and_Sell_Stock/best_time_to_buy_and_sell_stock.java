//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.


//Kadane's Algorithm
public class Solution {
    public int maxProfit(int[] prices) {
        int max=0;maxCur=0;
        for(int i=1;i<prices.length;i++){
	        maxCur = Math.max(0,maxCur+prices[i]-prices[i-1]);
	        max = Math.max(maxCur,max);
        }
        return max;
    }
}
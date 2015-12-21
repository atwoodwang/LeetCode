//You are climbing a stair case. It takes n steps to reach to the top.

//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//Only use constant space
public class Solution {
    public int climbStairs(int n) {
	    if(n<=2) return n;
		int a = 1;
		int b = 2;
		for(int i=3;i<n;i++){
			int sum = a+b;
			a=b;
			b=sum;
		}
		return a+b;
    }
}
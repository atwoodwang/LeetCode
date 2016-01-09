//Note: This is an extension of House Robber.

//After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.


public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0||nums==null) return 0;
        if(nums.length==1) return nums[0];
        return Math.max(maxRob(nums,0,nums.length-2),maxRob(nums,1,nums.length-1));
    }

    public int maxRob(int[] nums,int start,int end){
	    int rob=0;
	    int notrob=0;
	    for(int i=start;i<=end;i++){
		    int temp = notrob+nums[i];
		    notrob = Math.max(rob,notrob);
		    rob=temp;
	    }
	    return Math.max(rob,notrob);
    }
}
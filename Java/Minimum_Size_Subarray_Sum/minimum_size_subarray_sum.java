//Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0,quick=0,slow=0;
        int min = Integer.MAX_VALUE;
        while(quick<nums.length){
            while(quick<nums.length&&sum<s){
                sum+=nums[quick++];
            }
            if(sum<s){
                break;
            }
            while(sum>=s){
                sum-=nums[slow++];
            }
            min = Math.min(min,quick-slow+1);
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
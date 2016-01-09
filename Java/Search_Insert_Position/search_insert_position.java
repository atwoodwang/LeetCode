//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

//You may assume no duplicates in the array.

//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0


//Iteration
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) start=mid+1;
            else end=mid-1;
        }
        return start; 
    }
}

//Recursion
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1]) return nums.length;
		return binarysearch(nums,target,0,nums.length-1);
    }

    public int binarysearch(int[] nums,int target,int start,int end){
	    if(start>end) return start;
	    int n = (start+end)/2;
	    if(nums[n]==target) return n;
	    if(nums[n]<target) return binarysearch(nums,target,n+1,end);
	    else return binarysearch(nums,target,start,n-1);
    }
}
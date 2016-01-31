//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

//The replacement must be in-place, do not allocate extra memory.

//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1


public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2) return;
        int index = n-1;
        while(index>0){
	        if(nums[index]>nums[index-1]) break;
	        index--;
        }
        if(index==0){
	        reverse(nums,0,n-1);
	        return;
        }else{
	        index = index-1;
	        for(int i=n-1;i>index;i--){
		        if(nums[i]>nums[index]){
			        swap(nums,i,index);
			        break;
		        }
	        }
	        reverse(nums,index+1,n-1);
        }
    }

    public void swap(int[] nums,int a,int b){
	    int tmp = nums[a];
	    nums[a] = nums[b];
	    nums[b] = tmp;
    }

    public void reverse(int[] nums,int lo,int hi){
	    while(lo<hi){
		    swap(nums,lo++,hi--);
	    }
    }
}


//Following is the algorithm for finding the next greater number.
//I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.

//II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.

//III) Swap the above found two digits, we get 536974 in above example.

//IV) Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting is the output. For above example, we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.
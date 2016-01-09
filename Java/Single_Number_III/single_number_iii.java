//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

//For example:

//Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

//Note:
//The order of the result is not important. So in the above example, [5, 3] is also correct.
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?


public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff=0;
        for(int n:nums){
            diff^=n;
        }
        diff&=-diff;
        int[] result={0,0};
        for(int n:nums){
            if((n&diff)==0) result[0]^=n;
            else result[1]^=n;
        }
        return result;
    }
}

//If you were stuck by this problem, it's easy to find a solution in the discussion. However, usually, the solution lacks some explanations.

//I'm sharing my understanding here:

//The two numbers that appear only once must differ at some bit, this is how we can distinguish between them. Otherwise, they will be one of the duplicate numbers.

//Let’s say the at the ith bit, the two desired numbers differ from each other. which means one number has bit i equaling: 0, the other number has bit i equaling 1.

//Thus, all the numbers can be partitioned into two groups according to their bits at location i. the first group consists of all numbers whose bits at i is 0. the second group consists of all numbers whose bits at i is 1.

//Notice that, if a duplicate number has bit i as 0, then, two copies of it will belong to the first group. Similarly, if a duplicate number has bit i as 1, then, two copies of it will belong to the second group.

//by XoRing all numbers in the first group, we can get the first number. by XoRing all numbers in the second group, we can get the second number.
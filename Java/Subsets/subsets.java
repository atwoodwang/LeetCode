//Given a set of distinct integers, nums, return all possible subsets.

//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If nums = [1,2,3], a solution is:

//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

//Bit-Manipulation
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
	    Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
	    int n = 1<<nums.length;
	    for(int i=0;i<n;i++){
			List<Integer> list = new ArrayList<>();
		    for(int j=0;j<nums.length;j++){
			    if(((i>>j)&1)==1) list.add(nums[j]);
		    }
		    res.add(list);
	    }
	    return res;
    }
}


//Explaination
This is an amazing solution.Learnt a lot.Let me try to explain this to those who didn't get the logic.

 Number of subsets for {1 , 2 , 3 } = 2^3 .
 why ? 
case    possible outcomes for the set of subsets
  1   ->          Take or dont take = 2 
  2   ->          Take or dont take = 2  
  3   ->          Take or dont take = 2 

therefore , total = 2*2*2 = 2^3 = { { } , {1} , {2} , {3} , {1,2} , {1,3} , {2,3} , {1,2,3} }

Lets assign bits to each outcome  -> First bit to 1 , Second bit to 2 and third bit to 3
Take = 1
Dont take = 0

0) 0 0 0  -> Dont take 3 , Dont take 2 , Dont take 1 = { } 
1) 0 0 1  -> Dont take 3 , Dont take 2 ,   take 1       =  {1 } 
2) 0 1 0  -> Dont take 3 ,    take 2       , Dont take 1 = { 2 } 
3) 0 1 1  -> Dont take 3 ,    take 2       ,      take 1    = { 1 , 2 } 
4) 1 0 0  ->    take 3      , Dont take 2  , Dont take 1 = { 3 } 
5) 1 0 1  ->    take 3      , Dont take 2  ,     take 1     = { 1 , 3 } 
6) 1 1 0  ->    take 3      ,    take 2       , Dont take 1 = { 2 , 3 } 
7) 1 1 1  ->    take 3     ,      take 2     ,      take 1     = { 1 , 2 , 3 } 

In the above logic ,Insert S[i] only if (j>>i)&1 ==true   { j E { 0,1,2,3,4,5,6,7 }   i = ith element in the input array }

element 1 is inserted only into those places where 1st bit of j is 1 
   if( j >> 0 &1 )  ==> for above above eg. this is true for sl.no.( j )= 1 , 3 , 5 , 7 

element 2 is inserted only into those places where 2nd bit of j is 1 
   if( j >> 1 &1 )  == for above above eg. this is true for sl.no.( j ) = 2 , 3 , 6 , 7

element 3 is inserted only into those places where 3rd bit of j is 1 
   if( j >> 2 & 1 )  == for above above eg. this is true for sl.no.( j ) = 4 , 5 , 6 , 7 

Time complexity : O(n*2^n) , for every input element loop traverses the whole solution set length i.e. 2^n


//Iteration
public class Solution{
	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for(int i : S) {
            int size = res.size();
            for(int n=0;n<size;n++) {
                List<Integer> a = new ArrayList<>(res.get(n));
                a.add(i);
                res.add(a);
            }
        }
        return res;
    }
}
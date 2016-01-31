//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

//The update(i, val) function modifies nums by updating the element at index i to val.
//Example:
//Given nums = [1, 3, 5]

//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
//Note:
//The array is only modifiable by the update function.
//You may assume the number of calls to update and sumRange function is distributed evenly.


//Binary Indexed Tree
//O(NlgN) time to create, O(lgN) to query, O(lgN) to update
public class NumArray {
	int[] nums;
	int[] tree;
	int size;
    public NumArray(int[] nums) {
        this.nums = nums;
        size = nums.length;
        tree = new int[size+1];
        for(int i=0;i<size;i++){
	        updateTree(i,nums[i]);
        }
    }

	public void updateTree(int i,int val){
		i++;
		while(i<=size){
			tree[i]+=val;
			i+=(i&-i);
		}
	}
	
    void update(int i, int val) {
        updateTree(i,val-nums[i]);
   		nums[i]=val;
    }

    public int sumRange(int i, int j) {
        if(i==0) return sum(j);
        else return sum(j)-sum(i-1);
    }

    public int sum(int i){
	    i++;
	    int sum=0;
	    while(i>0){
		    sum+=tree[i];
		    i-=(i&-i);
	    }
	    return sum;
    }
}



// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
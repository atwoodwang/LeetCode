//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.

//Use PriorityQueue
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums){
	        queue.offer(num);
	        if(queue.size()>k){
		        queue.poll();
	        }
        }
        return queue.peek();
    }
}


//Use Selection Algo
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return select(nums,n-k,0,n-1);
    }


    public int select(int[] nums,int k, int start,int end){
        int m = Partition(nums,start,end);
        if(m==k) return nums[m];
        if(m>k) return select(nums,k,start,m-1);
        else return select(nums,k,m+1,end);
    }

    public int Partition(int[] nums,int start,int end){
        int num = nums[end];
        int i=start-1;
        for(int j=start;j<end;j++){
            if(nums[j]<=num){
                i++;
                exchange(nums,i,j);
            }
        }
        exchange(nums,i+1,end);
        return i+1;
    }

    public void exchange(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
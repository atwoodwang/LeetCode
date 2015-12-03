//Given a sorted integer array without duplicates, return the summary of its ranges.

//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();        
        int length = nums.length;
		for(int i=0;i<length;i++){
			int a = nums[i];
			while(i<length-1&&nums[i]+1==nums[i+1]){
				i++;
			}
			if(a==nums[i]){
				result.add(a+"");
			}else{
				result.add(a+"->"+nums[i]);
			}
		}
		return result;
    }
}
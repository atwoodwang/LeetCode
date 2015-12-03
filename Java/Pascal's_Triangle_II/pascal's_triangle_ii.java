//Given an index k, return the kth row of the Pascal's triangle.

//For example, given k = 3,
//Return [1,3,3,1].


public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
		result.add(0,1);
		if(rowIndex==0){
			return result;
		}
        for(int k=0;k<rowIndex;k++){
	        result.add(0,1);
	        for(int i=1;i<result.size()-1;i++){
		        result.set(i,result.get(i)+result.get(i+1));
	        }
        }
        return result;
    }
}
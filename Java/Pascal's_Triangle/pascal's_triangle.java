//Given numRows, generate the first numRows of Pascal's triangle.

//For example, given numRows = 5,
//Return

//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]


public class Solution {
    public List<List<Integer>> generate(int numRows) {
  	    List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		for(i=1;i<=numRows;i++){
			list.add(0,1);
			for(j=1;j<list.size()-1;j++){
				list.set(j,list.get(j)+list.get(j+1));
			}
			result.add(new ArrayList(list));
		}
		return result;
    }
}
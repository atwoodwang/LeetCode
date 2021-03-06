//Design and implement a TwoSum class. It should support the following operations: add and find.

//add - Add the number to an internal data structure.
//find - Find if there exists any pair of numbers which sum is equal to the value.

//For example,
//add(1); add(3); add(5);
//find(4) -> true
//find(7) -> false


public class TwoSum {
	Map<Integer,Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number,map.containsKey(number)?map.get(number)+1:1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Map.Entry<Integer,Integer> entry:map.entrySet){
		    int key = entry.getKey();
		    int num = entry.getValue();
		    int offset = value-key;
		    if((offset==key&&num>1)||(offset!=key&&!map.containsKey(offset))){
			    return true;
		    }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
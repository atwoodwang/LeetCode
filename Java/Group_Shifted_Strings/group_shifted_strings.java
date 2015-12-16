//Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

//"abc" -> "bcd" -> ... -> "xyz"
//Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

//For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
//Return:
 
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
//Note: For the return value, each inner list's elements must follow the lexicographic order.


public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
	    List<List<String>> result = new LinkedList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strings){
	        int offset = s.charAt(0)-'a';
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<s.length();i++){
		        char c = (char)(s.charAt(i)-offset);
		        if(c<'a'){
			        c+=26;
		        }
		        sb.append(c);
	        }
	        String key = sb.toString();
	        if(!map.containsKey(key)){
		        List<String> string = new LinkedList<>();
		        map.put(key,string);
	        }
	        map.get(key).add(s);
        }
        for(String key:map.keySet()){
	        List<String> list = map.get(key);
	        Collections.sort(list);
	        result.add(list);
        }
        return result;
    }
}
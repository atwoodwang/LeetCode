//Given an array of strings, group anagrams together.

//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:

//[
//  ["ate", "eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//Note:
//For the return value, each inner list's elements must follow the lexicographic order.
//All inputs will be in lower-case.


public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0||strs==null) return new ArrayList<List<String>>();
        HashMap<String,List<String>> map = new HashMap<>();
        Arrays.sort(strs);
        for(String s:strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedString = String.valueOf(c);
            if(!map.containsKey(sortedString)){
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(sortedString,list);
                continue;
            }
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
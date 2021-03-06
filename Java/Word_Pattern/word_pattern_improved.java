//Given a pattern and a string str, find if str follows the same pattern.

//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

//Examples:
//pattern = "abba", str = "dog cat cat dog" should return true.
//pattern = "abba", str = "dog cat cat fish" should return false.
//pattern = "aaaa", str = "dog cat cat dog" should return false.
//pattern = "abba", str = "dog dog dog dog" should return false.
//Notes:
//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space


//This way is easier to understand but runs slower.
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] strArray = str.split(" ");
        if(strArray.length!=pattern.length()){
	        return false;
        }
        for(int i=0;i<pattern.length();i++){
	        String s = strArray[i];
	        char c = pattern.charAt(i);
	        if(map.containsKey(c)){
                if(!map.get(c).equals(s)){
                    return false;
                }
            }else{
                if(map.containsValue(s)){
                    return false;
                }
                map.put(c,s);
            }
        }
        return true;
    }
}
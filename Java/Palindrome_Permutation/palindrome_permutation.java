//Given a string, determine if a permutation of the string could form a palindrome.

//For example,
//"code" -> False, "aab" -> True, "carerac" -> True.


public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
	        char temp = s.charAt(i);
	        if(set.contains(temp)){
		        set.remove(temp);
	        }else{
	            set.add(temp);
	        }
        }
   		return set.size()<=1;
    }
}
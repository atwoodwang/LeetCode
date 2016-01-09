//Given two strings s and t, write a function to determine if t is an anagram of s.

//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.

public class Solution {
    public boolean isAnagram(String s, String t) {
		if(s==null||t==null||s.length()!=t.length()) return false;
		int[] chars  = new int[26];
		for(int i=0;i<s.length();i++) chars[s.charAt(i)-'a']++;
		for(int i=0;i<t.length();i++){
			int j = t.charAt(i)-'a';
			if(--chars[j]<0) return false;
		}
		return true;
    }
}
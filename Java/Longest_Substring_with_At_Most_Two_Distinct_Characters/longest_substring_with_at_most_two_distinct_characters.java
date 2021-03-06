//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

//For example, Given s = “eceba”,

//T is "ece" which its length is 3.


public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
		int i=0,j=-1;
		int max = 0;
		for(int k=1;k<s.length();k++){
			if(s.charAt(k)==s.charAt(k-1)) continue;
			if(j>-1&&s.charAt(k)!=s.charAt(j)){
				max = Math.max(max,k-i);
				i=j+1;
			}
			j=k-1;
		}
		return max>(s.length()-i)?max:s.length()-i;
    }
}
//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


public class Solution {
	int low,maxLen;
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        for(int i=0;i<s.length();i++){
	        expand(s,i,i);
	        expand(s,i,i+1);
        }
        return s.substring(low,low+maxLen);
    }

    public void expand(String s,int i,int j){
	    while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
			i--;
			j++;
		}
			
		if(j-i-1>maxLen){
			maxLen = j-i-1;
			low = i+1;
		}
    }
}
//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.



public class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        if(s.length()<=1) return s;
        for(int i=0;i<s.length();i++){
	        expand(s,sb,i,i);
	        expand(s,sb,i,i+1);
        }
        return sb.toString();
    }

    public void expand(String s,StringBuilder sb,int i,int j){
	    while(i>=0&&j<s.length()){
		    if(s.charAt(i)==s.charAt(j)){
			    if(j-i+1>sb.length()){
				    sb.delete(0,sb.length());
				    sb.append(s.substring(i,j+1));
			    }
			    i--;
			    j++;
		    }else{
			    break;
		    }
	    }
    }
}
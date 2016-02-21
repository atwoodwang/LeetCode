//Given a string S and a string T, count the number of distinct subsequences of T in S.

//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

//Here is an example:
//S = "rabbbit", T = "rabbit"

//Return 3.


//O(n*m) time O(2*n) space where n is the length of s.
public class Solution {
    public int numDistinct(String s, String t) {
		int[] pre = new int[s.length()+1];
		int[] cur = new int[s.length()+1];
		for(int i=0;i<=s.length();i++){
			pre[i]=1;
		}
		for(int i=0;i<t.length();i++){
			for(int j=0;j<s.length();j++){
				if(t.charAt(i)==s.charAt(j)){
					cur[j+1]=cur[j]+pre[j];
				}else{
					cur[j+1]=cur[j];
				}
			}
			for(int k=0;k<s.length();k++){
				pre[k]=cur[k];
			}
		}
		return cur[s.length()];
    }
}


//O(n*m) time O(n*m) space, where n is the length of s, m is the length of t.
public class Solution {
    public int numDistinct(String s, String t) {
		int[][] dp = new int[t.length()+1][s.length()+1];
		for(int i=0;i<=s.length();i++){
			dp[0][i]=1;
		}
		for(int i=0;i<t.length();i++){
			for(int j=0;j<s.length();j++){
				if(t.charAt(i)==s.charAt(j)){
					dp[i+1][j+1]=dp[i+1][j]+dp[i-1][j-1];
				}else{
					dp[i+1][j+1]=dp[i+1][j];
				}
			}
		}
		return dp[t.length()][s.length()];
    }
}
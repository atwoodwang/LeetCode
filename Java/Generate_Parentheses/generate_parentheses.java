//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

//For example, given n = 3, a solution set is:

//"((()))", "(()())", "(())()", "()(())", "()()()"


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
		backtracking(res,"",0,0,n);
        return res;
    }

    public void backtracking(List<String> res,String s,int open,int close,int n){
	    if(s.length()==n*2){
		    res.add(s);
		    return;
	    }

	    if(open<n) backtracking(res,s+"(",open+1,close,n);
	    if(close<open) backtracking(res,s+")",open,close+1,n);
    }
}

//O(n) time O(1) space
public class Solution {
    public int numDecodings(String s) {
	    if(s==null||s.length()==0) return 0;
        int combine=0;
        int notcombine=1;
       	int pre = Character.getNumericValue(s.charAt(0));
       	if(pre==0) return 0;
        for(int i=1;i<s.length();i++){
	        int cur = Character.getNumericValue(s.charAt(i));
			int temp = notcombine;
			if(cur==0){
			  notcombine=0;
			  combine=pre<=2?temp:0;
			}else{
			    notcombine +=combine;
	            if(pre*10+cur<=26) combine = temp;
	            else combine = 0;
			}
			pre = cur;
        }
        return combine+notcombine;
    }
}

//O(n) space but less code
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }
}
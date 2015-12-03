//Given two binary strings, return their sum (also a binary string).

//For example,
//a = "11"
//b = "1"
//Return "100".


public class Solution {
    public String addBinary(String a, String b) {
	    if(a==null||a.length()==0){
		    return b;
	    }
	    if(b==null||b.length()==0){
		    return a;
	    }

	    StringBuilder sb = new StringBuilder();
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		int carry = 0;
		int sum = 0;
		int i = aArray.length-1;
		int j = bArray.length-1;

		while(i>-1||j>-1||carry==1){
			int x = (i>-1)?Character.getNumericValue(aArray[i--]):0;
			int y = (j>-1)?Character.getNumericValue(bArray[j--]):0;
			sum = x^y^carry;
			carry = (x+y+carry>=2)?1:0;
			sb.append(sum);
		}
		return sb.reverse().toString();
    }
}
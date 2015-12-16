//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.


public class Solution {
    public boolean isPalindrome(String s) {
        String string = "abcdefghijklmnopqrstuvwxyz";
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
	        char c = s.charAt(i);
	        if(string.indexOf(c)!=-1){
		        sb.append(c);
	        }
        }
        String a = sb.toString();
        String b = sb.reverse().toString();
        return a.equals(b);
    }
}
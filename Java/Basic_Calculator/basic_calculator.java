//Implement a basic calculator to evaluate a simple expression string.

//The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

//You may assume that the given expression is always valid.

//Some examples:
//"1 + 1" = 2
//" 2-1 + 2 " = 3
//"(1+(4+5+2)-3)+(6+8)" = 23

//Principle:

//(Sign before '+'/'-') = (This context sign);
//(Sign after '+'/'-') = (This context sign) * (1 or -1);
//Algorithm:

//Start from +1 sign and scan s from left to right;
//if c == digit: This number = Last digit * 10 + This digit;
//if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
//if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
//if c == '(': Push this context sign to stack;
//if c == ')': Pop this context and we come back to last context;
//Add the last num. This is because we only add number after '+' / '-'.

public class Solution {
    public int calculate(String s) {
        int res=0,sign=1,num=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        for(char ch:s.toCharArray()){
	        if(Character.isDigit(ch)){
		        num=num*10+ch-'0';
	        }else if(ch=='+'||ch=='-'){
		     	res +=sign*num;
		     	sign = stack.peek()*(ch=='+'?1:-1);
		     	num=0;
	        }else if(ch=='('){
		        stack.push(sign);
	        }else if(ch==')'){
		        stack.pop();
	        }
        }
        res +=sign*num;
        return res;
    }
}
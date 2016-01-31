//Given an integer, write a function to determine if it is a power of three.

//Follow up:
//Could you do it without using any loop / recursion?


//Without loop
public class Solution {
    public boolean isPowerOfThree(int n) {
        int maxPowerOfThree = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
        return n>0 && maxPowerOfThree%n==0;
    }
}

//With loop
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        while(n!=1){
            if(n%3!=0) return false;
            n/=3;
        }
        return true;
    }
}
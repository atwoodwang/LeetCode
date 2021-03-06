//Given an integer n, return the number of trailing zeroes in n!.

//Note: Your solution should be in logarithmic time complexity.


public class Solution {
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
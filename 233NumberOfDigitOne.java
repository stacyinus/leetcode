/*
233. Number of Digit One
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

Beware of overflow.
*/

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) 
            return 0; 
        if (n/10 < 0)
            return 1;
        int i = String.valueOf(n).length() - 1;
        System.out.println("i = " + i);
        int count = (int) Math.pow(9, i - 1) * i;
        int base = (int)Math.pow(10,i);
        System.out.println("base = " + base);
        if (n/base == 1)
            return count + (n - base);
        return (count + (n/base - 2) * count + countDigitOne(n - base));
        
    }
}